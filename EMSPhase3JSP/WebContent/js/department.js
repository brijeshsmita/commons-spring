function validateForm()
{
	//fetching the name of the form
	var x=document.forms["frmAddDepartment"]["deptName"].value;
	
	//var regex = /^[a-zA-Z/s]{3,20}*$/;
	var regex =/^[A-Za-z\s]{3,20}$/;
	if(x==null||x=="")
	{
		alert("Name is not in Proper format");
		return false;
	}
	
	if(!regex.test(x))
	{
		alert("In Name numbers are not allowed,"+x);
		return false;
	}
	
	
	/*
	var x=document.forms["myForm"]["kinId"].value;
	var kinIdRegex="^KIN([0-9])+$";
	if(!kinIdRegex.test(x))
	{
		alert("Wrong Format");
		return false;
	}
	
	var x=document.forms["frmAddDepartment"]["emailId"].value;
	var atpos=x.indexOf("@");
	var dotpos=x.lastIndexOf(".");
	
	if(x==null||x=="")
	{
		alert("Email must be filled out");
		return false;
	}
	else if(atpos<1||dotpos<atpos+2||dotpos+2>=x.length)
	{
			alert("Not a valid e-mail address");
			return false;
	}
	
	var x=document.forms["myForm"]["phoneNo"].value;
	var phoneRegex=/^[+]?(\d{2})\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;
	
	if(x==null||x=="")
	{
		alert("Phone Number must be filled out");
		return false;
	}
	
	if(!phoneRegex.test(x))
	{
		alert("Format must be (+91**********)");
		return false;
	}
	
	if(document.myForm.phoneNo.value==""||isNaN(document.myForm.phoneNo.value))
		{
			alert("Phone number not in proper format");
			//document.myForm.zip.focus();
			return false;
		}
	
	
	var x=document.forms["myForm"]["dob"].value;
	var d = new Date(x);
	var n = d.getFullYear();
	//alert("Year"+n);
	var y=new Date();
	var currentyear=y.getFullYear();
	//alert("current Year"+currentyear);
	if(x==null || x=="")
	{
	alert("DOB must be filled out");
	return false;
	}
	var regex = /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/;
	if(!regex.test(x))
	{
		alert("DOB should in yyyy/MM/dd format only");
		return false;
	}
	//alert(currentyear);
	//alert("Diff="+(currentyear-n));
	if((currentyear-n)<21||(currentyear-n)>60)
	{
		alert("Diff="+(currentyear-n));
		alert("You are not eligible, Age should be greater than 21 and below 60");
		return false;
	}
		
		var x=document.forms["myForm"]["doj"].value;
		var d = new Date(x);
		var n = d.getFullYear();
		//alert("Year"+n);
		var y=new Date();
		var currentyear=y.getFullYear();
		//alert("current Year"+currentyear);
		if(x==null || x=="")
		{
		alert("DOB must be filled out");
		return false;
		}
			var regex = /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/;
			if(!regex.test(x))
			{
				alert("DOJ should in yyyy/MM/dd format only");
				return false;
			}
			if(n==currentyear)
			{
				if(d.getMonth()>y.getMonth())
				{
					alert("Date of joining cant be greater than "+y);
					return false;
				}
				else
				{
					if(d.getMonth()==y.getMonth())
					{
						if(d.getDay()>y.getDay())
						{
							alert("Date of joining cant be greater than "+y.getDate());
							return false;
						}
					}
					
				}
			}
			if(n<1967||n>currentyear)
			{
				alert("Joining date cant be greater than current year or less than 1967");
				return false;
			}
		
	
*/
	//return(true);
	
}