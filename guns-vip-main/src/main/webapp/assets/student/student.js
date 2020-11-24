layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Student = {
        tableId: "studentTable"
    };

    /**
     * 初始化表格的列
     */
    Student.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'studentId', hide: true, title: 'id'},
            {field: 'studentName', sort: true, title: ''},
            {field: 'age', sort: true, title: ''},
            {field: 'sex', sort: true, title: ''},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Student.search = function () {
        var queryData = {};

        queryData['studentName'] = $('#studentName').val();

        table.reload(Student.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    Student.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/student/add'
    };

    /**
    * 跳转到编辑页面
    *
    * @param data 点击按钮时候的行数据
    */
    Student.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/student/edit?studentId=' + data.studentId
    };

    /**
     * 导出excel按钮
     */
    Student.exportExcel = function () {
        var checkRows = table.checkStatus(Student.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Student.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/student/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Student.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("studentId", data.studentId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Student.tableId,
        url: Feng.ctxPath + '/student/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Student.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Student.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    Student.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        Student.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Student.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Student.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            Student.onDeleteItem(data);
        }
    });
});
