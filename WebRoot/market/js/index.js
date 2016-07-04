$(document).ready(function () {
	judgeIsLogin();
	getNewGoods();
});

function getNewGoods() {
	$.ajax({
		type:'POST',
		url:'getNewGoods',
		data:{},
		dataType:'json',
		success:function (data) {
			if(data.successInfo.success==true){
				$.each(data.allGoodsInfo,function (index,item) {
					var module = $('#module').clone(true);
					module.removeAttr('id');
					module.find('.goods-link').attr('href','single.html?goodsId='+item.goodsId);
					module.find('.goods-img').attr('src',item.goodsImg);
					module.find('.goods-name').text(item.goodsName);
					module.find('.goods-price').text(item.goodsPrice);
					module.find('.goodsId').val(item.goodsId);
					$('#goodsListContainer').append(module);
				})
			}
		},
		complete:function () {
			$('.add-to-cart').bind('click',function () {
				var userId = $.cookie('userId');
				if(userId !== 'null'){
					var goodsId = $(this).children('.goodsId').val();
					insertShopcar(userId,goodsId);
				}else{
					$('#login-link').click();
				}
				
			})
		}
	});
}