import turtle
import random

def draw_maze(x,y):    # 맵크기를 인자로
    streightLenX = []   # 이동하는거리를 담는 리스트
    streightLenY = []
    streight = 0
    down = 0
    for i in range(2):              #윗변 아래변
        t.penup()
        if i==0:                    # 윗변
            t.goto(-300,200)        # 초기 위치로 이동
            t.pendown() 
            turnAngle = 90          # 회전각도 변
            while streight < x:         # 지정된 크기가 다 채워질때까지
                st =0
                if(x-streight > 100):                           # 100이하면 오류남으로
                    st = random.randrange(100,x-streight)//10
                else :
                    st =(x-streight)
                t.forward(st)               # 지정한만큼 전진
                streight+=st                # 이동한 거리 합산
                streightLenX.append(st)     # 이동한 거리 리스트에 저장
                
                t.right(turnAngle)          # 지그재그 회전
                turnAngle*=-1               # 지그재그를 위한 각도 

                if(y-down > 100):                           # 100이하면 오류남으로
                    st = random.randrange(100,y-down)//10
                else :
                    st =(y-down)
                t.forward(st)               # 마저 전진
                down+=st                    # 이동한 거리 합산
                streightLenY.append(st)             # 이동한 거리 리스트에 저장
            
        elif i==1:                          # 윗변과 같은 그림을 그
            t.home()
            turnAngle =90
            t.pendown
            t.goto(-330,170)
            t.pendown()
            for j in range(len(streightLenX)):
                t.forward(streightLenX[j])
               
                t.right(turnAngle)
                turnAngle*=-1
        
                t.forward(streightLenY[j])
    t.penup()
    t.home()
    


def turn_left():
    t.left(3)               # 터틀이 왼쪽으로 이동할 정도
    t.forward(1)            # 터틀이 이동한 길이
def turn_right():
    t.right(3)              # 터틀이 오른쪽으로 이동할 정도
    t.forward(1)               # 터틀이 이동한 길이

t = turtle.Turtle()
screen = turtle.Screen()
t.shape("turtle")
t.speed(10)
screen.onkey(turn_left, "Left")         #화살표 왼쪽 클릭시
screen.onkey(turn_right, "Right")       #화살표 오른쪽 클릭시

draw_maze(400,400)

t.speed(3)
t.goto(-315,185)                        #처음 위치로 이동
t.pendown()
screen.listen()
screen.mainloop()
