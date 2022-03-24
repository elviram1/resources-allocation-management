$('document').ready(function () {

    $('.table .open-edit-modal').on('click', function (){
        $(".modal-body #editId").val($(this).data('id'));
        $(".modal-body #editName").val($(this).data('name'));
        $(".modal-body #editSurname").val($(this).data('surname'));
        $(".modal-body #editInitials").val($(this).data('initials'));
        $(".modal-body #editLevel").val($(this).data('level'));
        $(".modal-body #editInternalExternal").val($(this).data('internalexternal'));
        $(".modal-body #editDailyHours").val($(this).data('dailyhours'));
        $(".modal-body #editMetadata").val($(this).data('metadata'));
    });

    $('.table #deleteButton').on('click', function (event){
        event.preventDefault();
        let href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href',href);
        $('#deleteModal').modal();
    });

});
