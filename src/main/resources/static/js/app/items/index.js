var main = {
    inint : function () {
        var _this = this;
        $('#items-btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save : function () {
        var data = {
            title : $('#product_title').val(),
            barcode : $('#bar_code').val(),
            content : $('#content').val(),
            contributor : $('#contributor').val(),
            price : $('#price').val()
        };

        $.ajax({
            type : 'POST',
            url : '/api/v1/items',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {

            alert(JSON.stringify(data))

            alert('Complete Register Items.');
            window.location.href = '/pos';     //  글 등록이 성공하면 메인페이지로 이동
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    update : function () {
        var data = {
            title : $('#title').val(),
            content : $('#content').val()
        };

        var id = $('#id').val()

        $.ajax({
            type : 'PUT',
            url : '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert("Complete Edit Post.")
            window.location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    delete : function () {
        var id = $('#id').val()

        $.ajax({
            type : 'DELETE',
            url : '/api/v1/posts/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8'
        }).done(function () {
            alert("Complete delete post.");
            window.location.href='/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.inint();