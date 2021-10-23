/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function createPagerWithDynamicURL(div, pageIndex, totalPage) {
    const GAP = 2;
    let currentUrl = location.href;
    currentUrl = currentUrl.replaceAll("&page=" + pageIndex, "");
    const container = document.getElementById(div);
    if (pageIndex > 1) {
        container.innerHTML += `<a href="&?page=${pageIndex - 1}">&laquo;</a>`;
    }
    if (pageIndex - GAP > 1) {
        container.innerHTML += `<a href="${currentUrl}&page=1">1</a>`;
        container.innerHTML += `<a onclick="goToPage('${currentUrl}')">...</a>`;
    }
    for (let i = pageIndex - GAP; i < pageIndex; i++) {
        if (i > 0) {
            container.innerHTML += `<a href="${currentUrl}&page=${i}">${i}</a>`;
        }
    }
    container.innerHTML += `<a  class="active">${pageIndex}</a>`;
    for (let i = pageIndex + 1; i <= pageIndex + GAP; i++) {
        if (i <= totalPage) {
            container.innerHTML += `<a href="${currentUrl}&page=${i}">${i}</a>`;
        }
    }
    if (pageIndex + GAP < totalPage) {
        container.innerHTML += `<a onclick="goToPage('${currentUrl}')">...</a>`;
        container.innerHTML += `<a href="${currentUrl}&page=${totalPage}">${totalPage}</a>`;
    }

    if (pageIndex < totalPage) {
        container.innerHTML += `<a href="${currentUrl}&page=${pageIndex + 1}">&raquo;</a>`;
    }
}

function createPager(div, pageIndex, totalPage) {
    const GAP = 2;
    const container = document.getElementById(div);
    let currentUrl = location.href;
    currentParam = currentUrl.split("&page=")[1];
    if(currentParam){
        currentParam = '&' + currentParam;
    } else {
        currentParam= '';
    }
    if (pageIndex > 1) {
        container.innerHTML += `<a href="?page=${pageIndex - 1}${currentParam}">&laquo;</a>`;
    }
    if (pageIndex - GAP > 1) {
        container.innerHTML += `<a href="?page=1${currentParam}">1</a>`;
        container.innerHTML += `<a onclick="goToPage()">...</a>`;
    }
    for (let i = pageIndex - GAP; i < pageIndex; i++) {
        if (i > 0) {
            container.innerHTML += `<a href="?page=${i}${currentParam}">${i}</a>`;
        }
    }
    container.innerHTML += `<a  class="active">${pageIndex}</a>`;
    for (let i = pageIndex + 1; i <= pageIndex + GAP; i++) {
        if (i <= totalPage) {
            container.innerHTML += `<a href="?page=${i}${currentParam}">${i}</a>`;
        }
    }
    if (pageIndex + GAP < totalPage) {
        container.innerHTML += `<a onclick="goToPage()">...</a>`;
        container.innerHTML += `<a href="?page=${totalPage}${currentParam}">${totalPage}</a>`;
    }

    if (pageIndex < totalPage) {
        container.innerHTML += `<a href="?page=${pageIndex + 1}${currentParam}">&raquo;</a>`;
    }
}

function goToPage(href) {
    let page = window.prompt("Go to page");
    page = parseInt(page);
    if (!page || page === "" || typeof (page) !== 'number') {
        return;
    } if (!href){
    window.location.href =  `?page=${page}`;
    } else {
         window.location.href =  `${href}&page=${page}`;
    }
}
