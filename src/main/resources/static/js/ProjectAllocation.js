projectGroups.forEach(function (projectGroup) {
    $('#table-project-group').append(
        "<table id='projectGroup-"+projectGroup.id + "'>" +
        "<tr>"+
        "<th>" + projectGroup.agency + "</th>"+
        "</tr>"+
        "</table>"
    );
    
});

projects.forEach(function (project) {
    $("#projectGroup-" + project.projectGroup.id).append(
        "<tr>" +
        "<td  class=\"nameProject\" style= 'border: 3px solid "+project.projectGroup.color+ " '>" + project.name + "</td>" +
        "<td id='project-" + project.id + "' style='display: flex'><span class='circle ml-1' style='border: 3px solid'>+</span></td>" +
        "</tr>"
    );
});

allocations.forEach(function (allocation, index){
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
    let border = allocation.resource.internalExternal ? "#010101" : "#00bfff";

    $("#project-"+allocation.project.id).prepend(
        "<div>" +
        "<span class=\"circle ml-1\"  style= 'border: 3px solid "+border+ " ; background-color: " + color + "'>" + allocation.resource.initials + " </span>"+
        "<span class=\"block\" >" + allocation.percentageOfEngagement + '%'+ " </span>"+
        "</div>"
    );
})