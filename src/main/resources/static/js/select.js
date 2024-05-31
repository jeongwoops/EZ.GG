let pieChart;

onload = function() {
  

    showPieChart();
    // canvasTest();

    const inputUsers = document.querySelectorAll('.inp-user');
    inputUsers.forEach((item)=>{
        item.addEventListener('input', (event)=>{
            const name = event.target.name;
            const value = event.target.value;
            if (value !== "")
                getWinRate(name,value);
        });
    });

}

const getWinRate = (name, value) => {
    $.ajax({
        url : "winrate/user",
        data : {nickName : value},
        success: (result)=>{
            console.log(result);
            if (result > -1) {
                $(`input[name=${name}]`).attr('rate', result);
                $(`input[name=${name}]`).removeClass('not-found');
                $(`input[name=${name}]`).removeAttr('title');
            } else {
                $(`input[name=${name}]`).attr('rate', 0);
                $(`input[name=${name}]`).addClass('not-found');
                $(`input[name=${name}]`).attr('title', '조회되지 않은 유저입니다.')
            }


            showPieChart();
        },
        error: (error)=>{
            console.log(error);
        }
    });
}

const showPieChart = () => {
    if (pieChart != undefined) {
        pieChart.destroy();
    }

    const pieCtx = document.getElementById('myChart');

    let x = 0;
    $(".t1").map((index, item)=>{
        const rate = $(item).attr("rate");
        if (rate != undefined) {
            x += parseInt(rate);
        }
    })
    let y = 0;
    $(".t2").map((index, item)=>{
        const rate = $(item).attr("rate");
        if (rate != undefined) {
            y += parseInt(rate);
        }
    })

    console.log(x, y)

    pieChart = new Chart(pieCtx, {
        type: 'pie',
        data: {
        labels: ['Team 1', 'Team 2'],
        datasets: [{
            label: '# of Votes',
            data: [x, y],
            borderWidth: 1
        }]
        },
        options: {
            scales: {
                y: {
                beginAtZero: true
                }
            }
        }
    });
}
