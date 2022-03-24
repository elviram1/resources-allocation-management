// Create chart senior/intermediate/junior
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

    //config chart
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
                },
                title: {
                    display: true,

                }
            }
        },
    };

    const myChart = new Chart(
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


    //get resources in internship and populate table
    let countInternship = 0;
    for(let i = 0; i<resources.length; i++){
        let resource = resources[i];
        if(resource.level == "internship") {
            countInternship++;
            $("#resources-in-internship > tbody").append(
                "<tr>" +
                "<td>" + resource.name + "</td>" +
                "<td>" + resource.surname + "</td>" +
                "<td>" + resource.initials + "</td>" +
                "</tr>"
            );
        }
    }
    document.getElementById('count-resources-in-internship').innerHTML = countInternship;


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

    //config chart
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
                },
                title: {
                    display: true,

                }
            }
        },
    };

    const myChart2 = new Chart(
        document.getElementById('chartBackendFrontend'),
        configDoughnut,

    );
