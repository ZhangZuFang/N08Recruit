var as = {

	/* 得到ajax對象 的方法 */
	getXhr : function() {
		var xhr;
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest(); // 非ie浏览器
		} else {
			xhr = new ActiveXObject('Microsoft.XMLHttp'); // ie浏览器
		}
		return xhr;
	},
	/* 把請求傳到controler */

	initSearch : function() {

		$("#m_button").click(
				function() {

					var xhr = as.getXhr();// 获得 ajax对象

					xhr.open('get', 'SMNumber.do', true);// open(请求方式,请求地址,同步/异步)

					xhr.send();// 只有调用 send 方法后，请求才会真正发送

					xhr.onreadystatechange = function() { // 注册回掉函数
						// 判断对象状态是否交互完成
						if (xhr.readyState == 4) {
							// 交互完成判断是否交互成功
							if (xhr.status == 200) {
								var result = xhr.responseText;// 接收服务器输出的数据
								// JSON.parse(result)函数用于将格式完好的JSON字符串转为与之对应的JavaScript对象。
								// 所谓"格式完好"，就是要求指定的字符串必须符合严格的JSON格式，例如：属性名称必须加双引号、字符串值也必须用双引号。
								var a = JSON.parse(result);
								alert(a[0].name);
								$("#selectdd").append(
										'<option>' + a[0].name + '</option>');
								$("#selectdd").append(
										'<option>' + a[0].acceptPerson
												+ '</option>');
								$("#selectdd")
										.append(
												'<option>' + a[0].address
														+ '</option>');

							}
						}

					};

				});

	},

}