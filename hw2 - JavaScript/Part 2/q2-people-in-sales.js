function getPeopleInSales() {
    let salesPeople = document.querySelectorAll('td');
    for (let i = 0; i < salesPeople.length; i++) {
        if (salesPeople[i].innerText === 'Sales') {
            console.log(salesPeople[i-1].innerText);
        }
    }
}