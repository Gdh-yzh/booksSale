var R = false, A = false, P = false;//用于验证表单


$(function(){
	$("#addressId").val(-1);
	var ops = $("#address");//下拉列表
	
	$.ajax({
		type:"POST",
		url:"order.do?method=2",
		dataType:"json",
		async:false,
		success:function(data){
			var addrs = data.addrs;
			appendOps(addrs);
			//console.log(addrs);
			ops.change(function(){
				fillForm(addrs,$(this).val());
			});
		}
	});
	
	//动态增加下拉列表
	function appendOps(addrs){
		for(var i=0;i<addrs.length;i++){
			ops.append("<option value='"+i+"'>"+i+":"+addrs[i].fullAddress.substr(0,6)+"...</option>");
		}
	}
	
	//根据选项智能填表
	function fillForm(addrs,index){
		if(index==-1){
			$("#receiveName").val('');
			$("#fullAddress").val('');
			$("#postalCode").val('');
			$("#phone").val('');
			$("#mobile").val('');
			$("#addressId").val('-1');
			return;
		}
		A=true;
		R=true;
		P=true;
		
		
		$("#nameValidMsg>span").html('');
		$("#addressValidMsg>span").html('');
		$("#receiveName").val(addrs[index].receiveName);
		$("#fullAddress").val(addrs[index].fullAddress);
		$("#postalCode").val(addrs[index].postalCode);
		$("#phone").val(addrs[index].phone);
		$("#mobile").val(addrs[index].mobile);
		
		$("#addressId").val(addrs[index].id);
	}
});

//表单验证
$(function(){
	R=false;A=false;P=false;
	$("#btnClientRegister").click(function(){
		if(R && A && P){
			return true;
		}else{
			return false;
		}
	});
	
	$("#receiveName").blur(function(){
		R = false;
		var val = $(this).val();
		var info = $("#name\\.info");
		info.html("");
		if(val == ""){
			info.text("收件人姓名不能为空");
		}else if(!val.match(/^[a-z0-9\u4e00-\u9efa5]{4,20}$/)){
			info.text("收件人姓名输入的格式不正确");
		}else{
			R = true;
			info.html("<img src='./images/my/ajax_ok.png' />");
		}
	});	
	
	$("#fullAddress").blur(function(){
		A = false;
		var val = $(this).val();
		var info = $("#address\\.info");
		info.html("");
		if(val == ""){
			info.text("收件人地址不能为空");
		}else if(!val.match(/^[a-z0-9\u4e00-\u9efa5]{4,20}$/)){
			info.text("收件人地址输入的格式不正确");
		}else{
			A = true;
			info.html("<img src='./images/my/ajax_ok.png' />");
		}
	});	
	
	$("#postalCode").blur(function(){
		P = false;
		var val = $(this).val();
		var info = $("#postalCode\\.info");
		info.html("");
		if(val == ""){
			info.text("收件邮箱不能为空");
		}else if(!val.match(/^[a-z0-9\u4e00-\u9efa5]{4,20}$/)){
			info.text("收件邮箱输入的格式不正确");
		}else{
			P = true;
			info.html("<img src='./images/my/ajax_ok.png' />");
		}
	});	
	
});
