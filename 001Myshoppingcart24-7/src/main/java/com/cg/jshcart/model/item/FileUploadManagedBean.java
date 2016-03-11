package com.cg.jshcart.model.item;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean
@SessionScoped
public class FileUploadManagedBean implements Serializable{
	private static final long serialVersionUID = -7771491502388284205L;
	UploadedFile file;
/*	private byte[] image;
	 //Spring Customer Service is injected...
   @ManagedProperty(value="#{imageDao}")
   ImageDAOImpl imageDao;
   */
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
 
    public String dummyAction(){
        System.out.println("Uploaded File Name Is :: "+file.getFileName()+" :: Uploaded File Size :: "+file.getSize());
        return "";
    }

  /*  public String saveImage() {    	
    	Image image = new Image();
    	try {
			image.setImage(file.getInputstream().toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return imageDao.saveImage(image);
    }
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public ImageDAOImpl getImageDao() {
		return imageDao;
	}

	public void setImageDao(ImageDAOImpl imageDao) {
		this.imageDao = imageDao;
	}*/
    
}
