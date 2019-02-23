<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>显示文本框的值</title>
   <script type="text/javascript" language="javascript">
   //旧密码调用鼠标跟随效果
   function old_pass(status,ev,id,label){
     var lab=document.getElementById(label).innerText;
	 if(lab==1){
	    old_pass_confirm(status,ev,id)
	 }
   }
   
   //旧密码验证跟随效果
   function old_pass_confirm(status,ev,id){
       var value=document.getElementById(id).value;
	   var object=document.getElementById(id);
	   var var_length=value.length;
	   if(var_length==0){
	     var lab9='请填写值';
		 document.getElementById('lable1').innerText=lab9;
		 fu(status,ev);
		 object.setAttribute("className","input");
	   }else{
	     var show = document.getElementById('showlianxi'); 
		 show.style.display='none'; 
		 object.setAttribute("className","");   
	   }
   }
   //密码框调用鼠标跟随效果
	function showlianxi(status,ev,id,label){ 
			var lab=document.getElementById(label).innerText;
			     if(lab==1){
				   yanzheng(status,ev,id);
			     }
		} 
   
	function yanzheng(status,ev,id){
	   var value=document.getElementById(id).value;
	   var object=document.getElementById(id);
	   var var_length=value.length;
	   var reg_small=new RegExp("^[a-z][a-z]*$");	
	   var reg_big=new RegExp("^[A-Z][A-Z]*$");
	   var reg_num=new RegExp("^[0-9][0-9]*$");
	   if(var_length==0){
			     var lab1='请填写值';
			     document.getElementById('lable1').innerText=lab1;
			     fu(status,ev);
				 object.setAttribute("className","input");
			}else if(var_length<6&&var_length>0){
			     var lab2='最小长度为6,当前长度为'+var_length+'.';
			     document.getElementById('lable1').innerText=lab2;
			     fu(status,ev);
				 object.setAttribute("className","input");
			} else if(var_length>20){
 			     var lab3='最大长度为20,当前长度为'+var_length;
			    document.getElementById('lable1').innerText=lab3;
				fu(status,ev);
				object.setAttribute("className","input");
			}else if(value.match(reg_small)||value.match(reg_big)){
			    var lab4='密码不能只包含小写或大写字母';
				document.getElementById('lable1').innerText=lab4;
				fu(status,ev);
				object.setAttribute("className","input");
			}else if(value.match(reg_num)){
			    var lab5='密码不能只包含数字';
				document.getElementById('lable1').innerText=lab5;
				fu(status,ev);
				object.setAttribute("className","input");
			}			
			else{
			var show = document.getElementById('showlianxi'); 
			show.style.display='none'; 
			object.setAttribute("className","");   
			}
	   
	}
		
	//确认密码调用鼠标跟随效果
	function showdiv(status,ev,id,conf_id,label){
	   var lab=document.getElementById(label).innerText;
		   if(lab==1){
			 confirm_pass(status,ev,id,conf_id);
		   }
	}	
	
	//验证再次输入的密码效果	
	function confirm_pass(status,ev,id,conf_id){
	   var value1=document.getElementById(id).value;
	   var value2=document.getElementById(conf_id).value;
	   var object=document.getElementById(conf_id);
	   var var_length=value2.length;
	   if(var_length==0){
		  var lab6='请填写值';
		  document.getElementById('lable1').innerText=lab6;
		  fu(status,ev);
		  object.setAttribute("className","input");
		}else if(value1!=value2){
		  var lab7='两次填写不一致，请重新填写';
		  document.getElementById('lable1').innerText=lab7;
		  fu(status,ev);
		  object.setAttribute("className","input");
		}else{
		   var show = document.getElementById('showlianxi'); 
			show.style.display='none'; 
		   object.setAttribute("className","");
		}
	}

    //鼠标跟随效果
     function fu(status,ev){
       	    var  e= ev||window.event; 
			var show = document.getElementById('showlianxi'); 
			var obj=e.target||e.srcElement; 
	     switch(status){ 
				case 'over': 
					show.style.position='absolute'; 
					if(e.pageX){ 
						show.style.left=e.pageX+20+'px'; 
						show.style.top=e.pageY+'px'; 
						} 
					else{ 
						show.style.left=e.clientX + document.body.scrollLeft+ document.documentElement.scrollLeft+5; 
						show.style.top=e.clientY + document.body.scrollTop+ document.documentElement.scrollTop+5; 
						} 
					show.style.display='block'; 
					break; 
				case 'out': 
				show.style.display='none'; 
				break; 
			   }
	 }
	 //旧密码的onblur事件调用此方法。
	 function old_psss_onblur(test,label){
	   var value= document.getElementById(test).value; 
       var object= document.getElementById(test);
	   var var_length=value.length; 
	   document.getElementById(label).innerText=1;  
	   if(var_length==0){
	      object.setAttribute("className","input");
		  return false;
	  }else{
	    object.setAttribute("className",""); 
		return true;	  
	  }
	}
	 
	 
	 //密码的onblur事件调用此方法。
	 function func(test,label){  
	      var reg_small=new RegExp("^[a-z][a-z]*$");	
		  var reg_big=new RegExp("^[A-Z][A-Z]*$");
		  var reg_num=new RegExp("^[0-9][0-9]*$"); 
          var value= document.getElementById(test).value; 
          var object= document.getElementById(test);
		  var var_length=value.length; 
		  document.getElementById(label).innerText=1;  
          if(value==null||value==''){   
            object.setAttribute("className","input");
			return false;
          }else if(var_length<6&&var_length>0){
		    object.setAttribute("className","input");
			return false;
		  }else if(var_length>20){
		    object.setAttribute("className","input");
			return false;
          }else if(value.match(reg_small)||value.match(reg_big)){
		    object.setAttribute("className","input");
			return false;
		  }else if(value.match(reg_num)){
		    object.setAttribute("className","input");
			return false;
		  }else{
		   object.setAttribute("className",""); 
		   return true;
		  }	 
		}  
		
	//确认密码的onblur事件调用此方法	
    function new_password_confirm(new_password,new_password_confirmation,label){ 
	       var new_passvalue=document.getElementById(new_password).value;
		   var new_pass_confirmvalue=document.getElementById(new_password_confirmation).value;
		   var new_pass_confirm_obj=document.getElementById(new_password_confirmation);
		   document.getElementById(label).innerText=1;  
		   if(new_pass_value.length==0){
		       new_pass_confirm_obj.setAttribute("className","input");
			   return false;
		   }else if(new_pass_value!=new_pass_confirm_value){
		       new_pass_confirm_obj.setAttribute("className","input");
			   return false;
		   }else{
		       return true;
		   }
    }	
	function tijiao(){
	  if(old_psss_onblur('username','old_pass')&&func('new_password','new_password_control')&&new_password_confirm('new_password','new_password_confirmation','new_password_confirmation_control')){
	    document.reform.submit();
	   }
	}
	
</script>
<style type="text/css"  >   
     .input{   
      border-color:#FF0000;   
      border-style:solid;   
       }
	 

</style> 
</head>
<body>
  <form name="reform" action="" method="post">
     <table align="center">
        <tr>
           <th width="200px" align="left">旧密码：
           </td>
           <td width="300px" colspan="2"><input type="text"  id="username"  onBlur="old_psss_onblur('username','old_pass')" onMouseOver="old_pass('over',event,'username','old_pass')" onMouseOut="old_pass('out',event,'username','old_pass')" style="width:200px">
           </td>
           
        </tr>
        <tr>
           <th align="left">
              新密码：
           </td>
           <td>
           <input type="password" id="new_password"  onmouseout="showlianxi('out',event,'new_password','new_password_control')"  onmousemove="showlianxi('over',event,'new_password','new_password_control')"  onBlur="func('new_password','new_password_control')" style="width:200px" />
           </td>
           <td><a style="font-size:13px">密码不允许纯数字或字母，长度大于5</a>
           </td>
        </tr>
        <tr>
           <th align="left">
           确认新密码：
           </td>
           <td colspan="2">
           <input type="text" id="new_password_confirmation" onMouseOut="showdiv('out',event,'new_password','new_password_confirmation','new_password_confirmation_control')" onMouseMove="showdiv('over',event,'new_password','new_password_confirmation','new_password_confirmation_control')" onBlur="new_password_confirm('new_password','new_password_confirmation','new_password_confirmation_control')"  style="width:200px"/>
           </td>
        </tr>
        <tr>
          <td colspan="3" align="center">
            <input type="button" value="提交" onClick="tijiao()">          </td>
        </tr>     
     </table>
     <div id="showlianxi" style="display:none;filter:alpha(opacity=50); background: #FF9999">  
    <label id="lable1"></label>
    </div>
    <label id="old_pass" style="display:none">0</label>
    <label id="new_password_control" style="display:none">0</label>
    <label id="new_password_confirmation_control" style="display:none">0</label>
</form>

</body>
</html>
