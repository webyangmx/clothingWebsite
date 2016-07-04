$(document).ready(function () {
	$('#login-link').click(function () {
		$('#mask').css('display','block');
		$('#login-register-window').css('display','block');

		$('#login-register-window').animate({width:400},200);
		$('#login-register-window').animate({height:410},400);
		setTimeout("$('#login-form').css('display','block')",600);
	});
	$('#register-link').click(function () {
		$('#login-form').slideUp(200);
		$('#login-register-window').animate({height:450},400);
		setTimeout("$('#register-form').slideDown()",200);
	});
	$('#return-login').click(function () {
		$('#register-form').slideUp(200);
		$('#login-register-window').animate({height:400},400);
		setTimeout("$('#login-form').slideDown()",200);
	});
	$('#mask').click(function () {
		$('#mask').fadeOut();
		$('#login-register-window,#login-form').css('display','none');
		$('#login-register-window').css('width','10%');
		$('#login-register-window').css('height','100px');
		$('#register-form').css('display','none');
	});

	$('#login-submit').click(function (event) {
		event.preventDefault();
		var username = $('#login-username').val();
		var password = $('#login-password').val();
		if(username && password){
			login(username,password);
		}
	});

	$('#register-submit').click(function () {
		event.preventDefault();
		var username = $('#register-username').val();
		var password = $('#register-password').val();
		var confirm = $('#confirm-password').val();
		if(username && password && confirm){
			regist(username,password);
		}
	});

	$('#logout-link').click(function (event) {
		logout($('#username').html());
	});
});
function login(username,password) {
	$.ajax({
		type:"POST",
		url:"login",
		data:{'username':username,'password':password},
		dataType:'JSON',
		success:function (data) {
			if(data.successInfo.success == true){
				$.cookie('userId',data.userInfo.userId);
				$.cookie('username',username);
				location.reload();
			}else{
				$('#error-password').show();
			}
		}
	});
}
function regist(username,password) {
	$.ajax({
		type:"POST",
		url:"register",
		data:{'username':username,'password':password},
		dataType:'JSON',
		success:function (data) {
			if(data.successInfo.success == true){
				alert("注册成功");
				$('#login-username').val(username);
				$('#login-password').val('');
				$('#return-login').click();
			}
		}
	});
}
function logout(username) {
	$.ajax({
		type:"POST",
		url:"logout",
		data:{'username':username},
		dataType:'JSON',
		success:function (data) {
			if(data.successInfo.success == true){
				$.cookie('username',null);
				$.cookie('userId',null);
				location.reload();
			}
		}
	});
}