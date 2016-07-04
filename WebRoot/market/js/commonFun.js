(function ($) {
    //扩展方法获取url参数
    $.getUrlParam = function (name) {
    	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    	var r = window.location.search.substr(1).match(reg);
    	if (r != null) return unescape(r[2]); 
    	return null;
    }
    //var urltype = $.getUrlParam('reurl');
})(jQuery);
function judgeIsLogin() {
	var username = $.cookie('username');
	if(username == null || username === 'null'){
		$('#login-link').show();
		$('#isLogin').hide();
		$('#logout-link').hide();
	}else if(username !== 'null'){
		$('#login-link').hide();
		$('#username').html(username);
		$('#isLogin').show();
		$('#logout-link').show();
		$('#mask').click();
	}
}
function insertShopcar(userId,goodsId) {
	$.ajax({
		type:'POST',
		url:'insertShopcar',
		data:{userId:userId,goodsId:goodsId},
		dataType:'json',
		success:function (data) {
			if(data.successInfo.success == true){
				alert("add to cart success");
			}else{
				alert("add to cart fail");
			}
		}
	});
}