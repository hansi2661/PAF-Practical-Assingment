// UPDATE========================================== 
$(document).on("click", ".btnUpdate", function(event) { 
	$("#hidPayIDSave").val($(this).closest("tr").find('#hidPayIDUpdate').val()); 
	$("#payType").val($(this).closest("tr").find('td:eq(0)').text()); 
	$("#payAmount").val($(this).closest("tr").find('td:eq(1)').text());  
	$("#payDate").val($(this).closest("tr").find('td:eq(2)').text());  
	$("#payEmail").val($(this).closest("tr").find('td:eq(3)').text()); 
	$("#payDesc").val($(this).closest("tr").find('td:eq(4)').text());

});