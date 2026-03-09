import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import NewVariable from './components/01_NewVariable.jsx'
import RouterTest from './pages/02_RouterTest.jsx'
import Query from './pages/03_Query.jsx'
import Path from './pages/04_Path.jsx'
import Extension from './pages/05_Extension.jsx'
import Props from './pages/06_Props.jsx'
import Rendering from './pages/07_Rendering.jsx'
import ListRendering from './pages/08_ListRendering.jsx'
import EventHandler from './pages/09_EventHandler.jsx'
import ProfilePage from './pages/training/Q1_ProfilePage.jsx'
import ButtonPage from './pages/training/Q2_ButtonPage.jsx'
import LoginPage from './pages/training/Q3_LoginPage.jsx'
import FruitPage from './pages/training/Q4_FruitPage.jsx'
import EvenPage from './pages/training/Q5_EvenPage.jsx'
import MenuPage from './pages/training/Q6_MenuPage.jsx'
import MessagePage from './pages/training/Q7_MessagePage.jsx'
import StudentPage from './pages/training/Q8_StudentPage.jsx'
import ResultPage from './pages/training/Q9_ResultPage.jsx'
import State from './pages/10_State.jsx'
import UseState from './pages/11_UseState.jsx'
import FormHendling from './pages/12_FormHandling.jsx'
import Lifting from './pages/13_Lifting.jsx'

import {createBrowserRouter, RouterProvider} from "react-router-dom"

const router = createBrowserRouter([
  {
    path: "/01", // URL
    element: <NewVariable/> // 해당 URL로 요청이 왔을 때 보여줄(렌더링 할) 함수
  },
  {
    path: "/02",
    element: <RouterTest/>
  },
  {
    path: "/03",
    element: <Query/>
  },
  {
    path: "/04/:value",
    element: <Path/>
  },
  {
    path: "/05",
    element: <Extension/>
  },
  {
    path: "/06",
    element: <Props/>
  },
  {
    path: "/07",
    element: <Rendering/>
  },
  {
    path: "/08",
    element: <ListRendering/>
  },
  {
    path: "/09",
    element: <EventHandler/>
  },
  {
    path: "/10",
    element: <State/>
  },
  {
    path: "/11",
    element: <UseState/>
  },
  {
    path: "/12",
    element: <FormHendling/>
  },
  {
    path: "/13",
    element: <Lifting/>
  },

  // ===========================================================================================================
  {
    path: "/Q1",
    element: <ProfilePage/>
  },
  {
    path: "/Q2",
    element: <ButtonPage/>
  },
  {
    path: "/Q3",
    element: <LoginPage/>
  },
  {
    path: "/Q4",
    element: <FruitPage/>
  },
  {
    path: "/Q5",
    element: <EvenPage/>
  },
  {
    path: "/Q6",
    element: <MenuPage/>
  },
  {
    path: "/Q7",
    element: <MessagePage/>
  },
  {
    path: "/Q8",
    element: <StudentPage/>
  },
  {
    path: "/Q9",
    element: <ResultPage/>
  }
])

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>
)
