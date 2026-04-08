const addBtn = document.querySelector('.button-add')
const input = document.querySelector('.input-box')
addBtn.addEventListener('click', function() {
    const text = input.value;
    fetch('/tasks', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({name: text})
    })
    .then(response => {
        return fetch('/tasks');
    })
    .then(response => response.json())
    .then(allTasks => {
        console.log("All tasks: ", allTasks);
        console.log(text);
        input.value = "";
        const list = document.getElementById('tasks-list');
        list.innerHTML = ""                                // cleares the input list before add
        allTasks.forEach(task => {
            const taskItem = document.createElement('li'); 
            const circle = document.createElement('span'); 
            circle.className = "circle"             
            taskItem.appendChild(circle)                                                                                                                                                                                                                       
            taskItem.appendChild(document.createTextNode(task.name))                                                                                                                                                                                           
            list.appendChild(taskItem)
            circle.addEventListener('dblclick', function(){
                taskItem.remove();
                fetch(`/tasks/${task.id}`, {
                    method: 'DELETE',
                })                                                                                                                                                                                                                     
            circle.addEventListener('click', function(){
                if (circle.className == "circle"){
                    circle.className = "circle-done"
                    circle.parentElement.style.textDecoration = "line-through"
                } else {
                    circle.className = "circle"
                    circle.parentElement.style.textDecoration = "none"
                }            
                }); 
            });
        });
    });
});
const text = input.value
fetch('/tasks')                                                                                                                                                                                                                                    
    .then(response => response.json()) 
    .then(allTasks => {
        console.log("All tasks: ", allTasks);
        console.log(text);
        input.value = "";
        const list = document.getElementById('tasks-list');
        list.innerHTML = ""                                 
        allTasks.forEach(task => { 
            const taskItem = document.createElement('li'); 
            const circle = document.createElement('span'); 
            circle.className = "circle"             
            taskItem.appendChild(circle)                                                                                                                                                                                                                       
            taskItem.appendChild(document.createTextNode(task.name))                                                                                                                                                                                           
            list.appendChild(taskItem)    
            circle.addEventListener('dblclick', function(){
                taskItem.remove();
                fetch(`/tasks/${task.id}`, {
                    method: 'DELETE',
                })                                                                                                                                                                                                                 
            circle.addEventListener('click', function(){
                if (circle.className == "circle"){
                    circle.className = "circle-done"
                    circle.parentElement.style.textDecoration = "line-through"
                } else {
                    circle.className = "circle"
                    circle.parentElement.style.textDecoration = "none"
                }            
                });                
            });
        });
    });
