const canvas = document.getElementById("game-board");
const ctx = canvas.getContext("2d");
const scale= 20;
const rows= canvas.height / scale;
const columns = canvas.width / scale;
const redWidth = canvas.width / 2;
const blueWidth = canvas.width - redWidth;
const minWidth = 0;
let score = 0;
let userA;
let redarea;
let bluearea;
let gameInterval;


(function setup() {
    userA = new UserA();
    redarea = new Redarea();
    bluearea = new Bluearea();


}());

function startGame() {
    if(!gameInterval) {
        gameInterval = setInterval(() => {
            ctx.clearRect(0,0,canvas.width, canvas.height);
            redarea.draw();
            bluearea.draw();
            userA.update();
            userA.draw();

            if (userA.eat(redarea)) {
                score++;
                document.getElementById("score").textContent = score;
                
            
            }else if (userA.eat(bluearea)) {
                score++;
                document.getElementById("score").textContent = score;
                
            }

            userA.checkCollision();
        }, 500);
    }
}

function stopGame() {
    clearInterval(gameInterval);
    gameInterval = null;
}

function gameOver() {
    stopGame();
}

function UserA() {
    
    const ran1 = Math.floor(Math.random() *40)+1;
    const ran3 = ran1 - scale > 0 ? 1 : -1;

    this.x = 190;
    this.y = 0;
    this.xSpeed = ran3 * scale;
    this.ySpeed = scale;

    this.getRandom = () => {
        this.ran1 = Math.floor(Math.random() * 40)+1;
        this.ran3 = this.ran1 - scale > 0 ? 1 : -1;
        this.xSpeed = this.ran3 * scale;
        this.ySpeed = scale;
    }
    
    this.draw = function () {
        ctx.fillStyle = "#e100ff";

        ctx.fillRect(this.x, this.y, scale, scale);
    };

    this.update=function () {
        this.getRandom()

        this.x += this.xSpeed;
        this.y += this.ySpeed;

        if (this.x <0 || this.y < 0 || this.x >=canvas.width || this.y >=canvas.height){
            gameOver();
        }
    };

     this.eat = function(redarea){
       const cpt = document.querySelector("input[name=captain]").value;
        if ( redarea.y===this.y ) {
            if(minWidth<=this.x && this.x<=(redWidth-scale)){
                alert(cpt+' : 레드팀!');
            } else {
                alert(cpt+' : 블루팀!');
            }
            return true;
        }
        return false;
     };

     this.checkCollision = function () {
        for (let i =0; i< this.tail.length; i++) {
            if(this.x === this.tail[i].x && this.y === this.tail[i].y){
                gameOver();
            }
        }
    };
    }

    function Redarea() {
        this.x = 0;
        this.y = 380;
        this.draw = function () {
            ctx.fillStyle = "#FF4136";
            ctx.fillRect(this.x, this.y, 200, scale);
        };
    }

    function Bluearea() {
        this.x = 200;
        this.y = 380;
        this.draw = function () {
            ctx.fillStyle = "#0048ff";
            ctx.fillRect(this.x, this.y, 200, scale);
        };
    }

    window.addEventListener("keydown", (event)=>{
        const direction = event.key.replace("Arrow","");
        snake.changeDirection(direction);
    });

    document.getElementById("start-btn").addEventListener("click", startGame);
    