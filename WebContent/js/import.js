/*$("#excel_button").on('click', function() {  
        var excel_file = $("#excel_file").val();  
        if (excel_file == "" || excel_file.length == 0) {  
            alert("请选择文件路径！");  
            return false;  
        } else {  
            return true;  
        }  
    }); */

//onsubmit事件无法触发，使用绑定按钮点击事件代替  
function check() {  
 var excel_file = $("#excel_SInfor").val();  
 if (excel_file == "" || excel_file.length == 0) {  
     alert("请选择文件路径！");  
     return false;  
 } else {  
        return true;  
    }  
}  

	
