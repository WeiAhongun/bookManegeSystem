/*查询书籍，并赋值给table*/
$(function () {
    var currentPage = 1;
    var pageSize = 5;
    var total = -1;
    var bookIds = [];

    /*search查询*/
    function searchPage() {
        $.get(`/book/queryAll?currentPage=${currentPage}&PageSize=${pageSize}`, $("#searchForm").serialize(), response => {
            if(response.status == 20000){
                var str = "";
                response.data.list.forEach(i => {
                    str += `<tr bookId="${i.bookId}">
                                <td><input type="checkbox" value="${i.bookId}" class="checkInput"></td>   
                                <td>${i.bookId}</td>
                                <td>${i.bookName}</td>
                                <td>${i.authorName}</td>
                                <td>${i.firstTypeName}</td>
                                <td>${i.secondTypeName}</td>
                                <td><img src="${i.imgUrl}" style="width: 40px"></td>
                                <td>
                                    <button class="btn btn-sm  btn-info editBtn" data-toggle="modal"
                                            data-target="#modal-default">
                                        编辑
                                    </button>
                                    <button class="btn btn-sm  btn-warning oprationDelBtn" data-toggle="modal" data-target="#delModal">
                                        删除
                                    </button>
                                </td>
                            </tr>`;

                })
                $("tbody").html(str);
                /*加载完成后调用事件*/
                setEditBtnClickListener();
                total = response.data.total
                initPagination(response.data.total)
            }
        })
    }

    searchPage();

    /*根据pageCount总行数分页*/
    function initPagination(pageCount) {
        $("#pagination").pagination(pageCount,    //分布总数量，必须参数
            {
                callback: PageCallback,  //PageCallback() 为翻页调用次函数。
                prev_text: "« 上一页",
                next_text: "下一页 »",
                items_per_page: pageSize,
                num_edge_entries: 2,       //两侧首尾分页条目数
                num_display_entries: 5,    //连续分页主体部分分页条目数
                current_page: currentPage - 1,   //当前页索引
                load_first_page: false
            });
    }

    /*分页回调函数*/
    function PageCallback(page) {
        currentPage = page + 1;
        searchPage();
    }

    /*获得分类*/
    function getBooktypeByParentId(id) {
        var str1 = `<option value="-1">一级分类</option>`;
        $.get(`/booktype/getBooktypeByParentId?id=${id}`, resp => {
            if(resp.status==20000){
                resp.data.forEach(i => {
                    str1 += `<option value="${i.typeId}">${i.typeName}</option>`;
                })
                $("#firstType2").html(str1);
                //添加书籍的弹出框的一级分类
                $("#firstType").html(str1);
            }
        })
    }

    getBooktypeByParentId(0)

    /*一级分类改变*/
    $("#firstType2").change(function () {
        var val = $("#firstType2").val();
        $.get(`/booktype/getBooktypeByParentId?id=${val}`, resp => {
            var str1 = `<option value="-1">二级分类</option>`;
            resp.data.forEach(i => {
                str1 += `<option value="${i.typeId}">${i.typeName}</option>`;
            })
            $("#secondType2").html(str1);
        })
    });
    $("#firstType").change(function () {
        var val = $("#firstType").val();
        $.get(`/booktype/getBooktypeByParentId?id=${val}`, resp => {
            var str1 = `<option value="-1">二级分类</option>`;
            resp.data.forEach(i => {
                str1 += `<option value="${i.typeId}">${i.typeName}</option>`;
            })
            $("#secondType").html(str1);
        })
    })

    /*搜索按钮点击事件*/
    $("#searchBtn").click(function () {
        currentPage = 1;

        searchPage()
    })

    /*文件上传*/
    function setFileChangeListener() {
        $("#avater").change(function (e) {
            var file = e.target.files[0];
            var formData = new FormData();
            formData.append("part", file)
            fileUpload(formData)
        })
    }

    setFileChangeListener()

    function fileUpload(formData) {
        $.ajax({
            type: "post",
            data: formData,
            url: "upload",
            contentType: false,
            processData: false,
            success: resp => {
                $(".bookimage").attr("src", resp.data)
                $("#imgUrl").val(resp.data)
            }
        })
    }

    /*添加书籍的按钮*/
    $("#addOrEdit").click(function () {

        $.post("book/addBook", $("#addorEidtForm").serialize(), function (resp) {
            formReset();
            searchPage();
        })
    })

    /*重置表单*/
    function formReset() {
        $("#addorEidtForm").get(0).reset();
        $(".bookimage").attr("src", "");
    }

    /*添加修改事件*/
    function setEditBtnClickListener() {
        //修改按钮点击后给表单赋值
        $(".editBtn").click(function () {
            var attr = $(this).parent().parent().attr("bookId");
            $.get("/book/query/" + attr, resp => {
                setFormValue(resp.data)
            })
        });
        //checkbox点击后给数组赋值
        $(".checkInput").click(function () {
            var bid = $(this).parent().parent().attr("bookId");
            var prop = $(this).prop("checked");
            if (prop) {
                bookIds.push(bid)
            } else {
                //删除数组中的元素，js写法
                bookIds.splice(bookIds.findIndex(function (i) {
                    return i = bid;
                }), 1)
            }

        })

        //给最右边的删除按钮设置事件
        $(".oprationDelBtn").click(function () {
            var bid1 = $(this).parent().parent().attr("bookId");
            //js清空数组
            bookIds = [];
            bookIds.push(bid1)
            $(".checkInput").prop("checked", false)
            console.log(bookIds)
        })
    }

    /*给表单赋值*/
    function setFormValue(book) {
        $("#bookName").val(book.bookName);
        $("#authorName").val(book.authorName);
        $("#firstType").val(book.firstTypeId);
        $("#description").val(book.description);
        $("#bookId").val(book.bookId);
        $.get(`/booktype/getBooktypeByParentId?id=${book.firstTypeId}`, resp => {
            var str1 = `<option value="-1">二级分类</option>`;
            resp.data.forEach(i => {
                str1 += `<option value="${i.typeId}">${i.typeName}</option>`;
            })
            $("#secondType").html(str1);
        })
        //防数据没有加载出来就赋值
        setTimeout(function () {
            $("#secondType").val(book.secondTypeId);
        }, 500)

        $("#imgUrl").val(book.imgUrl);
        $(".bookimage").attr("src", book.imgUrl)
    }


    /*点击添加书本按钮时重置表单*/
    $(".addBookBtn").click(function () {
        formReset()
    })

    /*弹出框 确认删除的按钮*/
    $(".delBtn").click(function () {
        //js拼接数组
        var s = bookIds.join("A");
        $.get("/book/delete?str=" + s, resp => {
            /*var lastPage = total%pageSize==0? total/pageSize : (total/pageSize)+1
            if(lastPage == currentPage){
                currentPage-1
            }*/
            searchPage()
        })
    })


})
