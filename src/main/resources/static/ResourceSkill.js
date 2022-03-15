$('document').ready(function () {

    $('.table .open-edit-modal').on('click', function (){
        $(".modal-body #editId").val($(this).data('id'));
        $(".modal-body #editResource").val($(this).data('resource'));
        $(".modal-body #editTechnicalSkill").val($(this).data('technicalskill'));
    });

    $('.table #deleteButton').on('click', function (event){
        event.preventDefault();
        let href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href',href);
        $('#deleteModal').modal();
    });

});