import React, { useState } from "react";
import axios from "axios";

function TableView() {
  console.log(localStorage.getItem("Id"))
  const id=localStorage.getItem("Id");
  const uri='http://localhost:8080/miniproject-1.0-SNAPSHOT/api'
  const [schedule,setSchedule]=useState([{}]);
  const [student,setStudent]=useState([{}]);
  const [time,setTime]=useState("");
  const handleSchedule=(event)=>{
      event.preventDefault()
      
      const val={

          'year':event.target[0].value,
          'term':event.target[1].value,

      }

        
      const urlBase = `${uri}/courses/getschedule/${id}/values?year=${val.year}&term=${val.term}`
      
      axios
      .get(`${urlBase}`)
      .then((json) => {
      console.log(json.data)
      const getSchedules=()=>{
        if(json.status===200){
          const newData =json.data;

          const result = newData.map((c,i) =>{
            const time=(i===0?("9:00"):((i===1)?("11:30"):((i===2)?("02:00"):"04:00")))
            return(time)
          }

          )

          // console.log(result);
          setTime(result)
          

          const result_new = newData.map(c => ({ 'Monday': c.Monday.substr(0,(c.Monday.lastIndexOf('/'))), 
          'Mon_course_id':c.Monday.substr((c.Monday.lastIndexOf('/')+1)),
          'Tuesday': c.Tuesday.substr(0,(c.Tuesday.lastIndexOf('/'))), 
          'Tue_course_id':c.Tuesday.substr((c.Tuesday.lastIndexOf('/')+1)),
          'Wednesday': c.Wednesday.substr(0,(c.Wednesday.lastIndexOf('/'))), 
          'Wed_course_id':c.Wednesday.substr((c.Wednesday.lastIndexOf('/')+1)),
          'Thursday': c.Thursday.substr(0,(c.Thursday.lastIndexOf('/'))), 
          'Thurs_course_id':c.Thursday.substr((c.Thursday.lastIndexOf('/')+1)),
          'Friday': c.Friday.substr(0,(c.Friday.lastIndexOf('/'))), 
          'Fri_course_id':c.Friday.substr((c.Friday.lastIndexOf('/')+1)),
          'Saturday': c.Saturday.substr(0,(c.Saturday.lastIndexOf('/'))), 
          'Sat_course_id':c.Saturday.substr((c.Saturday.lastIndexOf('/')+1))
          }));
          // console.log(result_new)


          setSchedule(result_new)
          setStudent([{}])
        }
        else{
          setSchedule([{}])
        }

      }

      getSchedules();

      })
      .catch((e) => {
        alert(e);
      });
   
  }

  function handleClick(course_id){
      // console.log(course_id);

      axios
      .get(`${uri}/courses/getstudents/${course_id}`)
      .then((json) => {


      // console.log(json.data)
      const getStudents=()=>{
        if(json.status===200){
          const newData =json.data;

          
          setStudent(newData)
        
        }
        else{
          setStudent([{}])
        }

      }

      getStudents();

      })
      .catch((e) => {
        alert(e);
      });

  }



  return (
    
    <>
    <form onSubmit={handleSchedule}>
    Year:<input type="text" placeholder="Year" name="year"/><br/>
    Term:<input type="text" placeholder="Term" name="term"/><br/>
    <button type="submit" value="Submit">Submit</button>

    
{time.length>0?

                    (<><br/>
                       <center> <h4><u>Time Table</u></h4></center><table border={1}className="detail">

                       <thead>
                    <tr>
                      <th>Time</th>
                        <th>Monday</th>
                        <th>Tuesday</th>
                        <th>Wednesday</th>
                        <th>Thursday</th>
                        <th>Friday</th>
                        <th>Saturday</th>
                    </tr>
                    </thead>
                    <tbody>
        
                    {schedule.map((val,i)=> {

                        return(<tr>
                          <td>{time[i]}</td>
                          {val.Monday?(<td><button type="submit" onClick={()=>{handleClick(val.Mon_course_id)}} >{val.Monday}</button></td>):(<td> - </td>)}
                          {val.Tuesday?( <td><button type="submit" onClick={()=>{handleClick(val.Tue_course_id)}} >{val.Tuesday}</button></td>):(<td> - </td>)}
                          {val.Wednesday?(   <td><button type="submit" onClick={()=>{handleClick(val.Wed_course_id)}} >{val.Wednesday}</button></td>):(<td> - </td>)}
                          {val.Thursday?(  <td><button type="submit" onClick={()=>{handleClick(val.Thurs_course_id)}} >{val.Thursday}</button></td>):(<td> - </td>)}
                          {val.Friday?(  <td><button type="submit" onClick={()=>{handleClick(val.Fri_course_id)}} >{val.Friday}</button></td>):(<td> - </td>)}
                          {val.Saturday?(  <td><button type="submit" onClick={()=>{handleClick(val.Sat_course_id)}} >{val.Saturday}</button></td>):(<td> - </td>)}
                        </tr>)
                    })}

                    </tbody>
                    </table></>):(<></>)
                }

    </form>

    {student[0].rollnumber?

(<><br/>
   <center> <h4><u>Student list</u></h4></center><table border={1}className="detail">

   <thead>
<tr>
  <th>Roll Number </th>
    <th>Full Name</th>
    <th>Email</th>
 
</tr>
</thead>
<tbody>

{student.map((val,i)=> {

    return(<tr>
      <td>{val.rollnumber}</td>
      <td>{val.name}</td>
      <td>{val.email}</td>
    </tr>)
})}

</tbody>
</table></>):(<></>)
}

</>
  );
}
export default TableView;