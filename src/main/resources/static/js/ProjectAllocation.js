let projectFteList = {};

projectGroups.forEach(function (projectGroup) {
    $('#container-projects-groups').append(
        "<table id='projectGroup-"+ projectGroup.id + "'>" +
        "<tr>"+
        "<th><button type='button' class='button-project-group' data-toggle='modal' data-target='#addProject'" +
        "data-projectGroupId='"+ projectGroup.id +"' data-projectGroupAgency='"+ projectGroup.agency +"'>+</button>" + projectGroup.agency + "</th>"+
        "</tr>"+
        "</table>"
    );
    
});

// Populate projects list
projects.forEach(function (project) {
    $("#projectGroup-" + project.projectGroup.id).append(
        "<tr>" +
        "<td id='prj-" + project.id + "' class='nameProject' style= 'border: 3px solid "+project.projectGroup.color+ " '>" + project.name + "</td>" +
        "<td id='project-" + project.id + "' style='display: flex'>" +
        "<button class='circle ml-1 open-add-modal' style='border: 3px solid' type='button'" +
        "data-toggle='modal' data-target='#addModal' data-project='" + project.id + "' data-projectName='"+ project.name +"'>+</button></td>" +
        "</tr>"
    );

    // Initialize project fte required list
    projectFteList[project.id] = {
        fteRequired: project.fteRequired,
        allocatedHours: 0
    };
});

allocations.forEach(function (allocation, index){
    // Populate allocations
    let color;
    switch(allocation.resource.level){
        case "senior" :
            color = "#ff0000";
            break;
        case "junior" :
            color = "#fce903";
            break;
        case "intermediate" :
            color = "#ff9900";
            break;
        case "internship" :
            color = "#909090";
        break;
    }
    let borderColor = allocation.resource.internalExternal ? "#010101" : "#00bfff";
    let borderStyle = allocation.investment ? "dashed" : "solid";
    if(allocation.project != null){
        $("#project-"+allocation.project.id).prepend(
            "<div id='" + allocation.id + "' class='open-close-allocation-menu  ml-1'>" +
            "<span class='circle'  style= 'border: 3px " + borderStyle + " " + borderColor + " ; background-color: " + color + "' " +
            "data-toggle='tooltip' title='" + allocation.resource.name + " " + allocation.resource.surname + "'>" + allocation.resource.initials + " </span>"+
            "<span class='block' >" + 12.5 * allocation.allocatedHours + "% </span>"+
            "</div>"
        );
        // Assign allocated hours in project fte required list
        projectFteList[allocation.project.id].allocatedHours += allocation.allocatedHours;
    }



})

$('document').ready(function () {
    // Show modal for Add new allocation
    let today = new Date();
    let dd = String(today.getDate()).padStart(2, '0');
    let mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    let yyyy = today.getFullYear();
    $('#container-projects-groups table button.open-add-modal').on('click', function (){
        const projectId = $(this).data('project');
        $("#project").val(projectId);
        $("#projectName").val($(this).data('projectname'));
        $("#startDateAllocation").val(yyyy + '-' + mm + '-' + dd);
        $("#endDateAllocation").val("9999-12-01");

        let resourcesAllocatedInThisProject = allocations.filter(allocation => (allocation.project != null && allocation.project.id == projectId));
        let optionsSelectBoxAvailableResource = "<option value=''>Select Resource</option>";

        for(let i in availableResourcesList) {
            let availableResource = availableResourcesList[i];
            let flagIsPresent = false;
            for (let j in resourcesAllocatedInThisProject) {
                let resourcesAllocated = resourcesAllocatedInThisProject[j];
                if (resourcesAllocated.resource.id === availableResource.id) {
                    flagIsPresent = true;
                    break;
                }
            }
            if (!flagIsPresent) {
                optionsSelectBoxAvailableResource += "<option value ='" + availableResource.id + "'> " + availableResource.name + " " + availableResource.surname + " </option>";
            }
        }
        $("#availableResources").html(optionsSelectBoxAvailableResource);
      });

    // Show modal for delete allocation
    $('#container-projects-groups table div.open-close-allocation-menu').on('click', function (event){
        event.preventDefault();
        $(".allocation-menu").css( {position:"absolute", top: event.pageY, left: event.pageX});
        $('.delete-allocation').attr('href', "/allocations/delete-project-allocation/" + event.currentTarget.id);
        $(".allocation-menu").toggle("slide");
    });

    // Delete allocation
    $('body .allocation-menu button.delete-allocation').on('click', function (event){
        event.preventDefault();
        $('#deleteModal #delRef').attr('href', $(this).attr('href'));
        $('#deleteModal').modal();
    });

    // Show modal for add project
    $('#container-projects-groups table button.button-project-group').on('click', function () {
        $("#projectGroupId").val($(this).data('projectgroupid'));
        $("#projectGroupAgency").val($(this).data('projectgroupagency'));
        $("#startDate").val(yyyy + '-' + mm + '-' + dd);
        $("#endDate").val("9999-12-01");
    })
});

//populate allocated hours by select input
function myFunction(e) {
    let resourceId = e.target.value;
    let allocatedHours;
    availableResourcesList.forEach(function (availableResource) {
        if (availableResource.id == resourceId){
            allocatedHours = availableResource.dailyHours;
        }
    })
    document.getElementById("allocatedHours").value = allocatedHours;
}

// list of resources by seniority
resources.forEach(function (resource) {
    let color;
    let border = resource.internalExternal ? "#010101" : "#00bfff";
    switch(resource.level){
        case "senior" :
            color = "#ff0000";
            $("#resources-senior").append(
                "<span class='circle ml-1 mb-3'  style= 'border: 3px solid "+border+ " ; background-color: " + color + "' " +
                "data-toggle='tooltip' title='" + resource.name + " " + resource.surname + "'>" + resource.initials + " </span>")
            break;
        case "intermediate" :
            color = "#ff9900";
            $("#resources-intermediate").append(
                "<span class='circle ml-1 mb-3'  style= 'border: 3px solid "+border+ " ; background-color: " + color + "' " +
                "data-toggle='tooltip' title='" + resource.name + " " + resource.surname + "'>" + resource.initials + " </span>")
            break;
        case "junior" :
            color = "#fce903";
            $("#resources-junior").append(
                "<span class='circle ml-1 mb-3'  style= 'border: 3px solid "+border+ " ; background-color: " + color + "' " +
                "data-toggle='tooltip' title='" + resource.name + " " + resource.surname + "'>" + resource.initials + " </span>")
            break;
        case "internship" :
            color = "#909090";
            $("#resources-internship").append(
                "<span class='circle ml-1'  style= 'border: 3px solid "+border+ " ; background-color: " + color + "' " +
                "data-toggle='tooltip' title='" + resource.name + " " + resource.surname + "'>" + resource.initials + " </span>")
            break;
    }

})

// Check if there is resources fte overload and if so show it in the GUI
Object.keys(projectFteList).forEach(projectId => {
    let fte = (projectFteList[projectId]['fteRequired'] * 8) - projectFteList[projectId]['allocatedHours']; // Convert fteRequired in hours and substract allocated hours
    if (fte < 0) {
        $("#prj-" + projectId).append("<br>! "+ projectFteList[projectId]['allocatedHours']/8 +" / " +projectFteList[projectId]['fteRequired'] + "</br>");
    }
});

// List available Resource
let availableResourcesList = [];
resources.forEach(function (resource) {
    let availableResource = {...resource};
    allocations.forEach(function (allocation) {
        if (availableResource.id == allocation.resource.id) {
            availableResource.dailyHours -= allocation.allocatedHours;
        }
    });
    if (availableResource.dailyHours > 0) {
        availableResourcesList.push(availableResource);
    }
});
availableResourcesList.forEach(function (availableResource){
    let color;
    switch(availableResource.level){
        case "senior" :
            color = "#ff0000";
            break;
        case "junior" :
            color = "#fce903";
            break;
        case "intermediate" :
            color = "#ff9900";
            break;
        case "internship" :
            color = "#909090";
            break;
    }
    let border = availableResource.internalExternal ? "#010101" : "#00bfff";
    let resource = resources.filter(resource => resource.id == availableResource.id)[0]; // TODO se problemi di efficienza valutare se trasformare la lista resources in una lista oggetti indicizzata
    let totalDailyHours = resource.dailyHours;
    $("#available-resources").append(
        "<div style='display: inline-block'>" +
        "<span class='circle ml-1'  style= 'border: 3px solid "+border+ " ; background-color: " + color + "' " +
        "data-toggle='tooltip' title='" + availableResource.name + " " + availableResource.surname + "'>" + availableResource.initials + " </span>"+
        "<span class='block' >" + (availableResource.dailyHours/totalDailyHours) * 100 + "% </span>" +
        "</div>"
    );
})


