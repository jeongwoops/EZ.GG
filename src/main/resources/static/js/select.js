onload = function() {
  

    showPieChart();
    canvasTest();
}


const showPieChart = () => {
    const pieCtx = document.getElementById('myChart');

    new Chart(pieCtx, {
        type: 'pie',
        data: {
        labels: ['Blue', 'Red'],
        datasets: [{
            label: '# of Votes',
            data: [65, 35],
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
