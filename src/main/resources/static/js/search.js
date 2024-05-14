const dataList = ["가렌", "갈리오", "갱플랭크", "그라가스","그레이브즈","그웬","나르","나미","나서스","나피리","노틸러스","녹턴"];

onload = () =>{ 
    const $search = document.querySelector("#search");
    const $autoComplete = document.querySelector(".autocomplete");
    
    let nowIndex = 0;
    
    $search.onkeyup = (event) => {
      // 검색어
      const value = $search.value.trim();
    
      // 자동완성 필터링
      const matchDataList = value
        ? dataList.filter((label) => label.includes(value))
        : [];
    
      switch (event.keyCode) {
        // UP KEY
        case 38:
          nowIndex = Math.max(nowIndex - 1, 0);
          break;
    
        // DOWN KEY
        case 40:
          nowIndex = Math.min(nowIndex + 1, matchDataList.length - 1);
          break;
    
        // ENTER KEY
        case 13:
          document.querySelector("#search").value = matchDataList[nowIndex] || "";
          document.getElementById("champion").value = document.querySelector("#search").value; 
          // 초기화
          nowIndex = 0;
          matchDataList.length = 0;
          break;
          
        // 그외 다시 초기화
        default:
          nowIndex = 0;
          break;
      }
    
      // 리스트 보여주기
      showList(matchDataList, value, nowIndex);
    };
    
    const showList = (data, value, nowIndex) => {
      // 정규식으로 변환
      const regex = new RegExp(`(${value})`, "g");
      
      $autoComplete.innerHTML = data
        .map(
          (label, index) => `
          <div class='${nowIndex === index ? "active" : ""}'>
            ${label.replace(regex, "<mark>$1</mark>")}
          </div>
        `
        )
        .join("");
    };
    
}
