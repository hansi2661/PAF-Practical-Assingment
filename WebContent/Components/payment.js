$(document).ready(function() {  
	if ($("#alertSuccess").text().trim() == "")  { 
		$("#alertSuccess").hide();  
		
	}  
	
	$("#alertError").hide();
	
});



//SAVE ============================================ 
$(document).on("click", "#btnSave", function(event) {  
//Clear status msges-------------  
$("#alertSuccess").text("");  
$("#alertSuccess").hide();  
$("#alertError").text("");  
$("#alertError").hide(); 

// Form validation---------------- 
var status = validateItemForm(); 

// If not valid-------------------  
if (status != true)  {   
$("#alertError").text(status);   
$("#alertError").show();   
return;  
} 

//If valid------------------------  

$("#formPayment").submit(); 

		
}); 

//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) {
	$("#hidPayIDSave").val($(this).closest("tr").find('#hidPayIDUpdate').val()); 
	$("#payType").val($(this).closest("tr").find('td:eq(0)').text());
	$("#payAmount").val($(this).closest("tr").find('td:eq(1)').text()); 
	$("#payDate").val($(this).closest("tr").find('td:eq(2)').text());
	$("#payEmail").val($(this).closest("tr").find('td:eq(3)').text());
	$("#payDesc").val($(this).closest("tr").find('td:eq(4)').text());
	
}); 


//validation
function validateItemForm() {  
	// paytype  
	if ($("#payType").val().trim() == "")  { 
		return "Insert pay type.";  
	} 
	// amount  
	if ($("#payAmount").val().trim() == "")  { 
		return "Insert pay amount.";  
	} 
	// date  
	if ($("#payDate").val().trim() == "")  { 
		return "Insert date .";  
	} 
	// email  
	if ($("#payEmail").val().trim() == "")  { 
		return "Insert email .";  
	} 
	// email  
	if ($("#payDesc").val().trim() == "")  { 
		return "Insert desc .";  
	} 
	 
	 return true;
	 
}








