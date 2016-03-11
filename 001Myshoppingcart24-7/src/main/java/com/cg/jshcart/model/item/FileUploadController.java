package com.cg.jshcart.model.item;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Blob;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import com.cg.jshcart.service.admin.ItemService;
  
@ManagedBean(name="fileUploadController")
public class FileUploadController implements Serializable {
	private static final long serialVersionUID = -7223881054378193830L;

	@ManagedProperty("#{itemService}")
	    private ItemService itemService;
	
   private String destination="\\";
   private UploadedFile file;
   private StreamedContent content;
 
    public StreamedContent getContent() {
	return content;
}

public void setContent(StreamedContent content) {
	this.content = content;
}

	public UploadedFile getFile() {
	return file;
}
    

public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

public void setFile(UploadedFile file) {
	this.file = file;
}

	public void upload(FileUploadEvent event) {  
    	file=event.getFile();
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
           // content = new DefaultStreamedContent(event.getFile().getInputstream(), destination, event.getFile().getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytesFile = new byte[event.getFile().getContents().length];
        System.arraycopy(event.getFile().getContents(),0,bytesFile,0,event.getFile().getContents().length);
   //     Blob blobImage=javax.sql.rowset.serial.SerialBlob(bytesFile);
        itemService.setImage(bytesFile);    
    }  
 
    public void copyFile(String fileName, InputStream in) {
           try {
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(destination + fileName));
              
                int read = 0;
                byte[] bytes = new byte[1024];
              
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                content = new DefaultStreamedContent(new ByteArrayInputStream(bytes),"/resources/images/", fileName);
                in.close();
                out.flush();
                out.close();
              
                System.out.println("New file created!");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }

   /* public StreamedContent getContent()
    {
        if(content == null)
        {
             use your database call here 
            BufferedInputStream in = new BufferedInputStream(ImageBean.class.getClassLoader().getResourceAsStream("test/test.png"));
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            int val = -1;
             this is a simple test method to double check values from the stream 
            try
            {
                while((val = in.read()) != -1)
                    out.write(val);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            byte[] bytes = out.toByteArray();
            System.out.println("Bytes -> " + bytes.length);
            content = new DefaultStreamedContent(new ByteArrayInputStream(bytes), "image/png", "test.png");
        }

        return content;
    }
*/
}
