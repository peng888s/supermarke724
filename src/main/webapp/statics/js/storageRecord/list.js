var storageRecordObj;

//入库记录管理页面上点击删除按钮弹出删除框(StorageRecordlist.jsp)
function deleteStoragerecord(obj){
	// alert(obj.attr("storageRecordId"));
	$.ajax({
		type:"GET",
		url:path+"/sys/storageRecord/del/"+obj.attr("storageRecordId"),
		//data:{storageRecordId:obj.attr("storageRecordId")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
			}else if(data.delResult == "false"){//删除失败
				//alert("对不起，删除订单【"+obj.attr("StorageRecordcc")+"】失败");
				changeDLGContent("对不起，删除订单【"+obj.attr("storageRecordcc")+"】失败");
			}else if(data.delResult == "notexist"){
				//alert("对不起，订单【"+obj.attr("StorageRecordcc")+"】不存在");
				changeDLGContent("对不起，订单【"+obj.attr("storageRecordcc")+"】不存在");
			}
		},
		error:function(data){
			alert("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeBi').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeBi').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	$(".viewStorageRecord").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		window.location.href=path+"/sys/storageRecord/view/" + obj.attr("storageRecordId");
	});
	
	$(".modifyStorageRecord").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/sys/storageRecord/toUpdate/" + obj.attr("storageRecordId");
	});
	$('#no').click(function () {
		cancleBtn();
	});
	
	$("#yes").click(function () {
		var obj = $(this);
		deleteStoragerecord(storageRecordObj);
		// window.location.href=path+"/sys/storageRecord/toUpdate/" + obj.attr("storageRecordId");
	});

	$(".deleteStorageRecord").on("click",function(){
		storageRecordObj = $(this);
		changeDLGContent("确定删除订单【"+storageRecordObj.attr("storageRecordcc")+"】吗？");
		openYesOrNoDLG();
	});
});