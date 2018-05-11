import turtle
def drawBar(height):
    t.begin_fill()                      # 채우는 부분 시작
    t.pensize(2)                        # 펜사이즈 설정
    t.color("blue")                     # 파랑색으로 설정
    t.fillcolor("red")                  # 채우는 색깔은 빨강
    t.left(90)                          # 펜이 오른쪽을 보고 있음으로 왼쪽으로 돌림
    t.forward(height)                   # 왼쪽 변
    t.write(str(height), font = ('Times New Roman', 16, 'bold')) #수치 표시
    t.right(90)                         # 첫 번째 코너
    t.forward(30)                       # 윗변
    t.right(90)                         # 두 번째 코너
    t.forward(height)                   # 오른쪽 변
    t.left(90)                          # 아래에 도착해서 처음 펜이 보던 방향으로
    t.end_fill()                        # 도형 색채우기
t = turtle.Turtle()                     # 터틀 선언
data = [120,56,309,220,156,23,98]       # 데이터를 담은 리스트
for i in data:                          # 데이터 값 내에서 반
    drawBar(i)
