$(document).ready(function() {
	$('.close').on('click', function(c){
		$(this).parent().fadeOut('slow', function(c){
			$(this).remove();
		});
	});
	judgeIsLogin();
	var userId = $.cookie('userId');
	if(userId !== 'null'){
		getShopcar(userId);  
	}
});

function getShopcar(userId) {
	$.ajax({
		type:'POST',
		url:'getShopcar',
		data:{userId:userId},
		dataType:'json',
		success:function (data) {
			if(data.successInfo.success==true){
				$('#shoppingCartList').html();
				$.each(data.allShopcarInfo,function (index,item) {
					var module = $('#module').clone(true);
					module.removeAttr('id');
					module.find('.cart-goods-link').attr('href','single.html?goodsId='+item.goodsId);
					module.find('.cart-goods-img').attr('src',item.goodsImg);
					module.find('.cart-goods-name').text(item.goodsName);
					module.find('.cart-goods-price').text(item.goodsPrice);
					module.find('.cart-goods-number').val(item.goodsNumber);
					$('#shoppingCartList').append(module);
				});
			}
		},
		complete:function () {
			$('.close').on('click', function(c){
				$(this).parent().fadeOut('slow', function(c){
					$(this).remove();
				});
			});
		}
	});
}
function updateShopCart(userId,goodsId) {
	$.ajax({
		type:'POST',
		url:'updateShopCart',
		data:{userId:userId,goodsId:goodsId},
		dataType:'json',
		success:function (data) {
			if(data.successInfo.success==true){
				
			}
		}
	});
}