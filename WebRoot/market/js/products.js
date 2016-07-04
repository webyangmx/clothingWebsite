$(document).ready(function(){
	$(".tab1 .single-bottom").hide();
	$(".tab2 .single-bottom").hide();

	$(".tab1 ul").click(function(){
		$(".tab1 .single-bottom").slideToggle(300);
		$(".tab2 .single-bottom").hide();
	});
	$(".tab2 ul").click(function(){
		$(".tab2 .single-bottom").slideToggle(300);
		$(".tab1 .single-bottom").hide();
	});
	judgeIsLogin();
	var categoryId = $.getUrlParam('category');
	getGoodsByCategoryId(categoryId);
});

function getGoodsByCategoryId(categoryId) {
	$.ajax({
		type:'POST',
		url:'getGoodsByCategoryId',
		data:{categoryId:categoryId},
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