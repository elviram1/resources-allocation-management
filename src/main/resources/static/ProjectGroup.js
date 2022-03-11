$('document').ready(function () {

    $('.table .open-edit-modal').on('click', function (){
    $(".modal-body #editProjectGroupId").val($(this).data('id'));
    $(".modal-body #editProjectGroupAgency").val($(this).data('agency'));
    $(".modal-body #editProjectGroupColor").val($(this).data('color'));
});
    $('.table #deleteButton').on('click', function (event){
        event.preventDefault();
        let href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href',href);
        $('#deleteModal').modal();
    });

});