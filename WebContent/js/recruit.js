/**
 * 
 */

// 收起展开按钮
hideTR = function(trid) {
	if (document.getElementById(trid).style.display == "") {
		document.getElementById(trid).style.display = "none";
	} else {
		document.getElementById(trid).style.display = "";
	}
};

jQuery(function() {

	

	var mydata = [ {
		name : "士大夫",
		sex : "男",
		examineeNum : "110112",
		identityNum : "15151515",
		political : "团员",
		phone : "11233344",
		address : "大别山下",
		province : "dee",
		grades : "2323"

	} ];

	jQuery("#list").jqGrid(
			{
				url : "searchAllStudent.do",// 获取数据的地址
				mtype : 'get',
				// data : mydata,
				datatype : "json",// datatype : "local",
				height : 350,  //可以调整jqGrid在页面的大小
				rowNum : 100,  //每页显示数据数量
				autowidth : true,
				shrinkToFit : true,
				rowList : [ 15, 30, 45 ],
				colNames : [ "s_id", "姓名", '性别', '成绩', '准考证号', '身份证号', '政治背景',
						'电话', '家庭住址', '籍贯' ],
				// colNames : [ "name", 'sex', 'examineeNum', 'identityNum'
				// ,'political','phone','address','province','grades'],
				colModel : [ {
					name : "s_id",
					width : "100",
					align : "center",
					index : "s_id",// 设置排序时所使用的索引名称，index名称会作为sidx参数（prmNames）传递到Server。
					hidden : true
				}, {
					name : "name",
					width : "100",
					align : "center",
					index : "name"
				}, {
					name : 'sex',
					width : "50",
					align : "center",
					index : 'sex'
				}, {
					name : 'grades',
					width : "50",
					index : 'grades',
					align : "center",
				}, {
					name : 'examineeNum',
					align : "center",
					index : 'examineeNum'
				}, {
					name : 'identityNum',
					index : 'identityNum',
					align : "center",
				}, {
					name : 'political',
					width : "100",
					index : 'political',
					align : "center",
				}, {
					name : 'phone',
					index : 'phone',
					align : "center",
				}, {
					name : 'address',
					index : 'address',
					align : "center",
				}, {
					name : 'province',
					width : "100",
					index : 'province',
					align : "center",
				} ],
				pager : "#plist",
				// rownumbers : true, //如果为ture则会在表格左边新增一列，显示行顺序号或是显示统计信息
				rownumWidth : 100,
				viewrecords : true, // 显示总记录数
				pgbuttons:true, //是否顯示分頁按鈕
				// caption : "AA", //表格名称
				// footerrow:true,
				jsonReader : { // jsonReader来跟服务器端返回的数据做对应
					root : "dataRows", // 代表实际模型数据的入口
					page : "currPage", // 代表当前页码的数据
					total : "totalPage",// 代表页码总数的数据
					records : "totalCount", // 查询出的记录数
					repeatitems : false
				// 如果设为false，则jqGrid在解析json时，会根据name来搜索对应的数据元素（即可以json中元素可以不按顺序）；而所使用的name是来自于colModel中的name设定。

				},
			});
	
});

/* 得到ajax對象 的方法 */
function getXhr() {
	var xhr;
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest(); // 非ie浏览器
	} else {
		xhr = new ActiveXObject('Microsoft.XMLHttp'); // ie浏览器
	}
	return xhr;
};
/* 把請求傳到controler */

function searchzhuanye() {
	$("#zhuanye").empty();// empty方法会清空 所有子元素 保留自己
	var departId = $("#yuanxi").val();
	var xhr = getXhr();
	xhr.open('get', 'searchProfessional.do?departId=' + departId, true);
	xhr.send();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			var result = xhr.responseText;
			if (xhr.status == 200) {
				// 转为适合脚本处理的脚本对象
				var a = JSON.parse(result);

				for (var i = 0; i < a.length; i++) {
					$("#zhuanye").append(
							'<option  value= ' + a[i].p_id + '>' + a[i].proName
									+ '</option>');
				}
				// 选中专业后查看专业id是否正确
				// alert( $("#zhuanye").val());
			}
		}
	};
};

// 选择好“专业”后，重新加载jqGrid
function reload() {
	// 获得“院系”和“专业”的id
	var d_id = $("#yuanxi").val();
	var p_id = $("#zhuanye").val();

	$("#list").jqGrid('setGridParam', { // setGridParam方法用于设置jqGrid的options选项
		datatype : 'json',
		postData : {
			'd_id' : d_id,
			'p_id' : p_id
		}, // 发送数据
		page : 1
	}).trigger("reloadGrid"); // 重新载入
};


// request generate all students under a depart and a professional 
function generateXmls(){
	var d_id = $("#yuanxi").val();
	var p_id = $("#zhuanye").val();
	var xhr = getXhr();
	xhr.open('get', 'generateXmls.do?departId=' + d_id,true);
	xhr.send();
};


// 打印操作
function print() {
	var id = $("#list").jqGrid("getGridParam", "selrow");// 获取到当前行的id
	var rowData = $("#list").jqGrid("getRowData", id);// 通过当前行的id，得到当前记录的“s_id”
	if (rowData.s_id == null) {
		alert("请选择一个学员");
	} else {
		var xhr = getXhr();
		xhr.open('get', 'printByS_id.do?s_id=' + rowData.s_id, true);
		xhr.send();
	}
};

