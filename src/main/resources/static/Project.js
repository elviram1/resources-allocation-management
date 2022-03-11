$('document').ready(function () {

    $('.table .open-edit-modal').on('click', function (){
        $(".modal-body #editId").val($(this).data('id'));
        $(".modal-body #editProjectGroup").val($(this).data('projectgroup'));
        $(".modal-body #editName").val($(this).data('name'));
        $(".modal-body #editStartDate").val($(this).data('startdate'));
        $(".modal-body #editEndDate").val($(this).data('enddate'));
        $(".modal-body #editFteRequired").val($(this).data('fterequired'));
        $(".modal-body #editMetadata").val($(this).data('metadata'));
    });


    $('.table #deleteButton').on('click', function (event){
        event.preventDefault();
        let href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href',href);
        $('#deleteModal').modal();
    });
});
