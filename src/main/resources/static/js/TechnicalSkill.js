$('document').ready(function () {

    $('.table .open-edit-modal').on('click', function (){
        $(".modal-body #editTechnicalSkillId").val($(this).data('id'));
        $(".modal-body #editTechnicalSkillSkill").val($(this).data('skill'));
        $(".modal-body #editType").val($(this).data('type'));
    });

    $('.table #deleteButton').on('click', function (event){
        event.preventDefault();
        let href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href',href);
        $('#deleteModal').modal();
    });

});


