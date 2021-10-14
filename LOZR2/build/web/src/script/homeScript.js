/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function doDeleteForum(id, name, ) {
    const message = `Do you want to delete forum: ${name}\nType 'confirm'`;
    let confirm = window.prompt(message);
    if (confirm === 'confirm') {
        window.location.href = "delete/forum?id=" + id;
    }
}




