  function SubmitForm() {
	  alter("@@@@@@");
       // document.getElementById("username").value = hex_md5(document.getElementById("username").value);
        document.getElementById("pwd").value = hex_md5(document.getElementById("pwd").value);
        alter(hex_md5(document.getElementById("pwd").value));
        //document.form1.submit
    };
   