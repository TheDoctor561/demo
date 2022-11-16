import * as React from 'react';
import { useState, useEffect } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@material-ui/core';

export default function Student() {
  const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
  const[Id, setId] = useState('')
  const[grades, setGrades]= useState([])
  const[students, setStudents] = useState([])

  const handleClickSearch=(e)=>{
    e.preventDefault()
    const path = "http://localhost:8080/api/v1/grade?studentId="+Id
    
    fetch(path)
    .then(response => response.json()).then((result)=> {
      setGrades(result); 
      setStudents([]); 
    });

    console.log(path)
  }
  const handleClickFive=(e)=>{
    e.preventDefault()
    console.log("Five")
    fetch("http://localhost:8080/api/v1/student").then(response => response.json())
    .then((result)=>{
      setStudents(result); 
      setGrades([]);
    }
    );
  }
  // useEffect(()=>{
  //   fetch("http://localhost:8080/api/v1/student")
  //   .then(res=>res.json())
  //   .then((result)=>{
  //     setStudents(result); 
  //   }
  //   )
  // },[])
  return (
    <Container>
    <Paper elevation={3} style={paperStyle}>
    <Box
      component="form"
      sx={{
        '& > :not(style)': {
          m: 1
        },
      }}
      noValidate
      autoComplete="off"
    >
      
      <h1 style={{color:"blue"}}><u>Lookup Grades</u></h1>
      <TextField id="outlined-basic" label="Student Id" variant="outlined" fullWidth
      value = {Id}
      onChange ={(e)=>setId(e.target.value)}/>
      
      <Button variant="contained" color="secondary" onClick={handleClickSearch}>
        Search
      </Button>
      <Button variant="contained" color="primary" onClick={handleClickFive}>
        Five
      </Button>
    </Box>
    </Paper>
    <Paper elevation={3} style={paperStyle}>
      {students.map(student=>(
        <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={student.id}>
          Id: {student.id}<br/>
          Name: {student.firstName}<br/>
          Address: {student.lastName}<br/>
          Email: {student.email}<br/>
          Date of birth: {student.dob}<br/>
          Number of Classes: {student.numClasses}<br/>
        </Paper>
      ))}

      {grades.map(grade=>(
        <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={grade.id}>
          Grade: {grade.grade}<br/> 
          Student Id: {grade.studentId}<br/>
          Course Id: {grade.courseId}<br/>
          Professor Id: {grade.professorId}<br/>
        </Paper>
      ))}
    </Paper>
    </Container>
  );
}
