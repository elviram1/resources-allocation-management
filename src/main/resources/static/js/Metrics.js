//get senior/intermediate/junior
let juniorCount = 0;
let intermediateCount = 0;
let seniorCount = 0;
let internship = 0;
resources.forEach(function(res) {
    if (res.level == "junior") {
        juniorCount++;
    } else if (res.level == "intermediate") {
        intermediateCount++;
    } else if (res.level == "senior") {
        seniorCount++;
    }else if (res.level == "internship"){
        internship++;
    }
});

//config chart senior/intermediate/junior
const data = {
    labels: ['Junior', 'Intermediate', 'Senior', 'Internship'],
    datasets: [{
        label: 'My First Dataset',
        data: [juniorCount, intermediateCount, seniorCount, internship],
        backgroundColor: [
            'rgb(255, 205, 86)',
            'rgb(255, 165, 0)',
            'rgb(247,70,74)',
            'rgb(156, 156, 156)'
        ],
        hoverOffset: 4
    }]
};

const config = {
    type: 'pie',
    data: data,
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'bottom',
            }
        }
    },
};

const pieChartLevel = new Chart(
    document.getElementById('pieChartLevel'),
    config,
);


// Get unallocated resources and populate table
let count = 0;
for (let i = 0; i < resources.length; i++) {
    let resource = resources[i];
    for (let j = 0; j < allocations.length; j++) {
        let allocation = allocations[j];
        if (resource.id == allocation.resource.id) {
            break;
        } else if (j == allocations.length - 1) {
            count++;
            $("#unallocated-resources > tbody").append(
                "<tr>" +
                "<td>" + resource.name + "</td>" +
                "<td>" + resource.surname + "</td>" +
                "<td>" + resource.initials + "</td>" +
                "<td>" + resource.level + "</td>" +
                "<td>" + resource.dailyHours + "</td>" +
                "</tr>"
            );
        }
    }
}
document.getElementById('count-unallocated-resources').innerHTML = count;


//get technical skill and populate table
for(let i = 0; i<technicalSkills.length; i++){
    let technicalSkill = technicalSkills[i];
    $("#technical-skill > tbody").append(
        "<tr>" +
        "<td>" + technicalSkill.skill + "</td>" +
        "</tr>"
    );
}


//get resources backend frontend
let backend = 0;
let frontend = 0;
let backend_frontend =0;
for (let i = 0; i < resourceSkills.length; i++){
    let resourceSkill = resourceSkills[i];
    for(let j = 0; j < technicalSkills.length; j++){
        let technicalSkill = technicalSkills[j];
        if(resourceSkill.technicalSkill.id == technicalSkill.id && technicalSkill.type == "BE"){
            backend++;
        }else if(resourceSkill.technicalSkill.id == technicalSkill.id && technicalSkill.type == "FE"){
            frontend++;
        }else if(resourceSkill.technicalSkill.id == technicalSkill.id && technicalSkill.type == "BE/FE"){
            backend_frontend++;
        }
    }
}

//config chart resources backend frontend
const dataDoughnut = {
    labels: ['Backend', 'Frontend', 'Backend/Frontend'],
    datasets: [{
        label: 'My First Dataset',
        data: [backend, frontend, backend_frontend],
        backgroundColor: [
            'rgb(247,70,74)',
            'rgb(54, 162, 235)',
            'rgb(255, 205, 86)'
        ],
        hoverOffset: 4
    }]
};

const configDoughnut= {
    type: 'doughnut',
    data: dataDoughnut,
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'bottom',
            }
        }
    },
};

const chartBackendFrontend = new Chart(
    document.getElementById('chartBackendFrontend'),
    configDoughnut,

);


//get resources in internship and populate table
let countInternship = 0;
for(let i = 0; i<resources.length; i++){
    let resource = resources[i];
    if(resource.level == "internship"){
        countInternship++;
        for( let j = 0; j<allocations.length; j++){
            let allocation = allocations[j];
            if(allocation.resourceFollowed != null && allocation.resourceFollowed.id == resource.id) {
                $("#resources-in-internship > tbody").append(
                    "<tr>" +
                    "<td>" + resource.name + "</td>" +
                    "<td>" + resource.surname + "</td>" +
                    "<td>" + resource.initials + "</td>" +
                    "<td>" + resource.dailyHours + "</td>" +
                    "<td>" + allocation.resource.name + " " + allocation.resource.surname + "</td>" +
                    "<td>" + allocation.startDate + "</td>" +
                    "</tr>"
                );
            }
        }
    }
}
document.getElementById('count-resources-in-internship').innerHTML = countInternship;


//get project, fte required, fte allocated and populate table
projects.forEach(function (project) {
    let allocatedHours = 0;
    allocations.forEach(function (allocation) {
        if (allocation.project != null && allocation.project.id == project.id) {
            allocatedHours += allocation.allocatedHours;
        }
    });
    const fteAllocated = allocatedHours / 8;

    $("#project-table > tbody").append(
         "<tr>" +
         "<td>" + project.name + "</td>" +
         "<td>" + project.fteRequired + "</td>" +
         "<td>" + fteAllocated + "</td>" +
         "</tr>"
    );
});


//get Project Groups with fte allocated
let nameProjectGroup = [];
let colorProjectGroup = [];
let fteAllocated = [];
projectGroups.forEach(function (projectGroup) {
    let allocatedHours = 0;
    nameProjectGroup.push(projectGroup.agency);
    colorProjectGroup.push(projectGroup.color);
    allocations.forEach(function (allocation) {
        if (allocation.project != null && allocation.project.projectGroup.id == projectGroup.id) {
            allocatedHours += allocation.allocatedHours;
        }
    });
    fteAllocated.push(allocatedHours / 8);
})

//config chart project Groups with fte allocated
const dataPieChart = {
    labels: nameProjectGroup,
    datasets: [{
        data: fteAllocated,
        backgroundColor: colorProjectGroup,
        hoverOffset: 4
    }]
};

const configPieChart = {
    type: 'pie',
    data: dataPieChart,
    options: {
        responsive: true,
        plugins: {
            legend: {
                position: 'bottom',
            },
        }
    },
};

const pieChartProjectGroups = new Chart(
    document.getElementById('pieChartProjectGroups'),
    configPieChart,
);
