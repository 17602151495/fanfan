$(function () {
    $("#table").BT({
        url: baseURL + 'hotel/hotel/list',
        columns: [
            {checkbox: true},
			{ title: '店长ID', field: 'userid'},
			{ title: '店铺名字', field: 'name'},
			{ title: '联系电话', field: 'tel'},
			{ title: '店铺图片', field: 'hotelpic'},
			{ title: '店铺介绍', field: 'introduce'},
			{ title: '营业开始时间', field: 'startime'},
			{ title: '营业结束时间', field: 'endtime'},
			{ title: '省', field: 'province'},
			{ title: '市', field: 'city'},
			{ title: '县区', field: 'county'},
			{ title: '详细地址', field: 'address'},
			{ title: '经度', field: 'longitude'},
			{ title: '纬度', field: 'latitude'},
			{ title: '店铺分类（1饭店 2 酒店 3快餐店 4 食堂）', field: 'classification'},
			{ title: '经营类型（1烧烤香锅 2 休闲茶饮 3中餐地方 3.1 鲁菜）', field: 'mtype'},
			{ title: '级别 1 总店 2 分店 3 连锁店', field: 'level'},
			{ title: '经营状态（1营业中 2 暂停营业 3即将开业）', field: 'mstate'},
			{ title: '店铺状态 （正常 ，下线，欠费,违规） ', field: 'sta'},
			{ title: '', field: 'createTime'},
			{ title: '', field: 'updateTime'},
			{ title: '', field: 'createby'},
			{ title: '', field: 'updateby'}
        ],
		//条件查询
        queryParams:vm.params
    });

    var map = new BMap.Map("allmap");
    var point = new BMap.Point(116.331398,39.897445);
    map.centerAndZoom(point,12);
    map.enableScrollWheelZoom(true);

    var geoc = new BMap.Geocoder();

    var marker = new BMap.Marker(point);
    marker.enableDragging();
    marker.addEventListener("dragend", function(e){
        // alert("当前位置：" + e.point.lng + ", " + e.point.lat);
        geoc.getLocation(point, function(rs){
            //addressComponents对象可以获取到详细的地址信息
            var addComp = rs.addressComponents;
            var site = addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber;
            alert("当前位置：" +site);
            vm.hotel.province=addComp.province;
            vm.hotel.city= addComp.city;
            vm.hotel.county= addComp.district;
            vm.hotel.address=addComp.province + addComp.city + addComp.district  + addComp.street  + addComp.streetNumber;
            vm.hotel.longitude=e.point.lng;
            vm.hotel.latitude=e.point.lat;
        });
    })
    // 将标注添加到地图中
    map.addOverlay(marker);
    map.addEventListener("click", function(e){
        //通过点击百度地图，可以获取到对应的point, 由point的lng、lat属性就可以获取对应的经度纬度
		var pot = e.point;
        geoc.getLocation(pot, function(rs){
            //addressComponents对象可以获取到详细的地址信息
            var addComp = rs.addressComponents;
            var site = addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber;
            alert("当前位置：" +site);
            vm.hotel.province=addComp.province;
            vm.hotel.city=addComp.city;
            vm.hotel.county=addComp.district;
            vm.hotel.address=addComp.province + addComp.city + addComp.district  + addComp.street  + addComp.streetNumber;
            vm.hotel.longitude=pot.lng;
            vm.hotel.latitude=pot.lat;
            console.log(site);   //详细地址
            // console.log(pot.lng); //精度
            // console.log(pot.lat); //纬度
        });


        //删除标注
        var allOverlay = map.getOverlays();
        for(var i = 0;i<allOverlay.length;i++) {
            //删除指定经度的点
            map.removeOverlay(allOverlay[i]);
        }
        //重新创建标注
        marker = new BMap.Marker(pot);
        marker.enableDragging();
        marker.addEventListener("dragend", function(e){
            // alert("当前位置：" + e.point.lng + ", " + e.point.lat);
            geoc.getLocation(pot, function(rs){
                //addressComponents对象可以获取到详细的地址信息
                var addComp = rs.addressComponents;
                var site = addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber;
                alert("当前位置：" +site);
                vm.hotel.province=addComp.province;
                vm.hotel.city=addComp.city;
                vm.hotel.county=addComp.district;
                vm.hotel.address= addComp.province + addComp.city + addComp.district  + addComp.street  + addComp.streetNumber;
                vm.hotel.longitude=e.point.lng;
                vm.hotel.latitude=e.point.lat;
            });
        })
        map.addOverlay(marker);

    });


    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');

});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: false,
		title: "店铺信息",
		params:{
		    name:'',
		},
		hotel: {
			province:"",
            city:"",
            county:'',
            address:'',
            longitude:"",
            latitude:'',

		},
        dialogImageUrl: '',
        dialogVisible: false,
		//店铺图片上传
        appupdloud: baseURL +"app/fileDownload/upload",
		//店铺性质
        level:[{value: '1', label: '自营店'}, {value: '2', label: '加盟店'}, {value: '3', label: '连锁店'}, {value: '4', label: '总店'}, {value: '5', label: '分店'}],
		//经营状态
        mstate:[{value: '1', label: '营业中'}, {value: '2', label: '暂停营业'}, {value: '3', label: '即将开业'}],
		//店铺分类
        classification:[{value: '1', label: '饭店'}, {value: '2', label: '酒店'}, {value: '3', label: '快餐'}, {value: '4', label: '食堂'}],
        //店铺状态
        sta:[{value: '1', label: '正常'}, {value: '2', label: '下线'}, {value: '3', label: '违规'}, {value: '4', label: '欠费'}],
        //经营类型
        mtype:[],
        visible2: false,
        defaultProps: {
            children: 'children',
            label: 'label'
        },
	},
	methods: {

		//图片处理
        handleRemove:function(file, fileList) {
            console.log(file, fileList);
            console.log(file, fileList);
        },
		//图片删除
        handlePictureCardPreview:function(file) {
            this.dialogImageUrl = file.url;
            this.dialogVisible = true;
        },
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.hotel = {};
		},
		update: function (event) {
           	var id = getSelectedRowId("id");
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.hotel.id == null ? "hotel/hotel/save" : "hotel/hotel/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.hotel),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRowsId("id");
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "hotel/hotel/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
                                vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "hotel/hotel/info/"+id, function(r){
                vm.hotel = r.hotel;
            });
		},
		reload: function (event) {
			vm.showList = true;
			//刷新 如需条件查询common.js
            $("#table").BTF5();
		},
		init:function () {
            $.get(baseURL + "hotel/hmanagementtype/init", function(r){
                vm.mtype = r.data;
                console.log("==============",JSON.stringify(vm.mtype));
            });
        }
	},
    created:function(){
        this.init();
	}
});




function isFocus(e){
    alert(UE.getEditor('editor').isFocus());
    UE.dom.domUtils.preventDefault(e)
}
function setblur(e){
    UE.getEditor('editor').blur();
    UE.dom.domUtils.preventDefault(e)
}
function insertHtml() {
    var value = prompt('插入html代码', '');
    UE.getEditor('editor').execCommand('insertHtml', value)
}
function createEditor() {
    enableBtn();
    UE.getEditor('editor');
}
function getAllHtml() {
    alert(UE.getEditor('editor').getAllHtml())
}
function getContent() {
    var arr = [];
    arr.push("使用editor.getContent()方法可以获得编辑器的内容");
    arr.push("内容为：");
    arr.push(UE.getEditor('editor').getContent());
    alert(arr.join("\n"));
}
function getPlainTxt() {
    var arr = [];
    arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
    arr.push("内容为：");
    arr.push(UE.getEditor('editor').getPlainTxt());
    alert(arr.join('\n'))
}
function setContent(isAppendTo) {
    var arr = [];
    arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
    UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
    alert(arr.join("\n"));
}
function setDisabled() {
    UE.getEditor('editor').setDisabled('fullscreen');
    disableBtn("enable");
}

function setEnabled() {
    UE.getEditor('editor').setEnabled();
    enableBtn();
}

function getText() {
    //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
    var range = UE.getEditor('editor').selection.getRange();
    range.select();
    var txt = UE.getEditor('editor').selection.getText();
    alert(txt)
}

function getContentTxt() {
    var arr = [];
    arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
    arr.push("编辑器的纯文本内容为：");
    arr.push(UE.getEditor('editor').getContentTxt());
    alert(arr.join("\n"));
}
function hasContent() {
    var arr = [];
    arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
    arr.push("判断结果为：");
    arr.push(UE.getEditor('editor').hasContents());
    alert(arr.join("\n"));
}
function setFocus() {
    UE.getEditor('editor').focus();
}
function deleteEditor() {
    disableBtn();
    UE.getEditor('editor').destroy();
}
function disableBtn(str) {
    var div = document.getElementById('btns');
    var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
    for (var i = 0, btn; btn = btns[i++];) {
        if (btn.id == str) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        } else {
            btn.setAttribute("disabled", "true");
        }
    }
}
function enableBtn() {
    var div = document.getElementById('btns');
    var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
    for (var i = 0, btn; btn = btns[i++];) {
        UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
    }
}

function getLocalData () {
    alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
}

function clearLocalData () {
    UE.getEditor('editor').execCommand( "clearlocaldata" );
    alert("已清空草稿箱")
}