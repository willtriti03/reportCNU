def makeList():
    global list_length
    while 1:                                # 끝을 입력 받을 때까지 무한 반복
        tmp= input("끝또는 숫자 입력")      # 입력 받음
        if (tmp =="끝"):                    # 입력이 끝이면 반복문 탈출
            break
        else :                              # 입력이 숫자면 리스트에 추가하고 길이 증가
            data.append(int(tmp))
            list_length+=1

    print(data)                             # 입력된 리스트 출력

def bubbleSortB(length):                    
    list_length = length
    FLAG =1                                 # 순서 변경 체크를 위한 변수

    while FLAG :                            # 리스트를 전부 확인해서 소팅이 완료되면 반복을 종료한다
        list_length-=1                      # 맨 처음 1을 빼고 시작하는 이유는 리스트를 반복하여 검사할때
                                            # 현재칸과 그 다음 칸을 비교하므로
                                            # 리스트의 맨 마지막을 검사할때 [마지막+1]칸을 참조하게 되는데
                                            # 그 경우 list index out of range가 발생함으로 방지하기 위해서 전체 길이에서 1을 뺀다
                                            # 반복문을 돌면서 1을 빼는 이유는 소팅이 완료된 부분을 건들 필요가 없기 때문이다
        FLAG = 0                            # while문을 반복할 때마다 변경되지 않은 상태로 친다
        FLAG = bubbleSortS(list_length)

    print (data)
def bubbleSortS(length):
    FLAG = 0
    for i in range(0,length):               # 0에서부터 끝까지 반복한다
           if(data[i]>=data[i+1]):          # 앞에 칸의 데이터가 뒷칸 데이터보다 클 경우 두 데이터의 위치를 바꾼다
               tmp = data[i]
               data[i]=data[i+1]
               data[i+1]=tmp
               FLAG = 1                     # 변경을 했다는것을 표시
    return FLAG
    
data = []                                   # 정수 리스트
list_length = 0                             # 리스트 길이
makeList()
bubbleSortB(list_length)
