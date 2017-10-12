/**
 * Created by Travis Brindley on 9/9/2017.
 */

function getDate(){
    var test = document.getElementById("startDate").value;
    var parts =test.split('-');
    var firstDate = new Date(parts[0],parts[1]-1,parts[2]);
    var secondDate = new Date(parts[0],parts[1]-1,parts[2]);
    secondDate.setDate(secondDate.getDate() + 1);

    //creates arrays for months & week day
    var nameMonth = ["Jan","Feb", "Mar","Apr", "May","Jun","Jul","Aug","Sep","Oct", "Nov", "Dec"];
    var daysOfWeek = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];

    //selected day from date form field
    var firstDay = firstDate.getDate();
    var firstMonth = firstDate.getMonth();
    var firstWeekDayNum = firstDate.getDay();

    //selected day plus 1 for past midnight fields
    var secondDay = secondDate.getDate();
    var secondMonth = secondDate.getMonth();
    var secondWeekDayNum = secondDate.getDay();

    //string output
    var firstoutput = daysOfWeek[firstWeekDayNum] + ", " + nameMonth[firstMonth] + " " + firstDay;
    var secondoutput = daysOfWeek[secondWeekDayNum] + ", " + nameMonth[secondMonth] + " " + secondDay;

    //updates select option fields
    document.getElementsByName('endTime')[0].options[1].innerHTML = firstoutput + " - 6 pm";
    document.getElementsByName('endTime')[0].options[2].innerHTML = firstoutput + " - 7 pm";
    document.getElementsByName('endTime')[0].options[3].innerHTML = firstoutput + " - 8 pm";
    document.getElementsByName('endTime')[0].options[4].innerHTML = firstoutput + " - 9 pm";
    document.getElementsByName('endTime')[0].options[5].innerHTML = firstoutput + " - 10 pm";
    document.getElementsByName('endTime')[0].options[6].innerHTML = firstoutput + " - 11 pm";
    document.getElementsByName('endTime')[0].options[7].innerHTML = secondoutput + " - 12am";
    document.getElementsByName('endTime')[0].options[8].innerHTML = secondoutput + " - 1 am";
    document.getElementsByName('endTime')[0].options[9].innerHTML = secondoutput + " - 2 am";
    document.getElementsByName('endTime')[0].options[10].innerHTML = secondoutput + " - 3 am";
    document.getElementsByName('endTime')[0].options[11].innerHTML = secondoutput + " - 4 am";
}
function getQuitTime(){
    var startTime = document.getElementById("startTime").value;
    var endtimes = document.getElementsByName('endTime')[0];

    for(var i = 0; i < endtimes.options.length; i++){
        if(startTime >= endtimes.options[i].value){
            endtimes.options[i].style.visibility = "hidden";
        }
        if(startTime+1 == endtimes.options[i].value){
            endtimes.value = endtimes.options[i].value;
        }
    }
}