/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function createPager(div, pageIndex, totalPage) {
    const GAP = 2;
    const container = document.getElementById(div);
    if (pageIndex > 1) {
        container.innerHTML += `<a href="?page=${pageIndex - 1}">&laquo;</a>`;
    }
    if (pageIndex - GAP > 1) {
        container.innerHTML += `<a href="?page=1">1</a>`;
        container.innerHTML += `<a onclick="goToPage()">...</a>`;
    }
    for (let i = pageIndex - GAP; i < pageIndex; i++) {
        if (i > 0) {
            container.innerHTML += `<a href="?page=${i}">${i}</a>`;
        }
    }
    container.innerHTML += `<a  class="active">${pageIndex}</a>`;
    for (let i = pageIndex + 1; i <= pageIndex + GAP; i++) {
        if (i <= totalPage) {
            container.innerHTML += `<a href="?page=${i}">${i}</a>`;
        }
    }
    if (pageIndex + GAP < totalPage) {
        container.innerHTML += `<a onclick="goToPage()">...</a>`;
        container.innerHTML += `<a href="?page=${totalPage}">${totalPage}</a>`;
    }

    if (pageIndex < totalPage) {
        container.innerHTML += `<a href="?page=${pageIndex + 1}">&raquo;</a>`;
    }

}

function goToPage(){
    const page = window.prompt("Go to page");
    if(!page || page===""){
        return
    }
    window.location.href =  `?page=${page}`;
}
