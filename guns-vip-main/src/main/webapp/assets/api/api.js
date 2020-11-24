layui.use(['layer', 'form', 'table', 'ztree', 'jquery', 'laydate', 'admin', 'ax','upload'], function () {
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var $ZTree = layui.ztree;
    var $ax = layui.ax;
    var laydate = layui.laydate;
    var admin = layui.admin;
    var upload = layui.upload;
    var $ = layui.jquery;



    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        var apiPath = $("#apiPath").val();
        var content = $("#content").val();
        var ajax = new $ax(Feng.ctxPath + "/api/requestApi", function (returnData) {


            // var jdata = JSON.stringify(JSON.parse(returnData), null, 4);
            //这时数据展示正确  json格式格式化输出
            Feng.infoDetail("日志详情", "<pre>"+ JSON.stringify(returnData, null, '  ')+"</pre>");

            // var btn = document.querySelector('#json');
            // // var data = {name:'tim', age: 23, grade: 3};
            // btn.textContent = JSON.stringify(returnData, null, '  ');
            // window.location.href = Feng.ctxPath + '/api/requestApi';
        }, function (data) {
            Feng.error("" + data)
        });
        var requestMap = {"content": content,"apiPath": apiPath};

        // map.content = content;
        ajax.set(requestMap);
        ajax.start();
    });

});