import { useState, useRef } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import Editor from "@monaco-editor/react"
import './App.css'

const files = {
  "script.py": {
    name: "script.py",
    language: "python",
    value: "print (\"Hello World\")"
  },
  "index.html": {
    name: "index.html",
    language: "html",
    value: "<div>Hello World</div>"
  }
}

function App() {
  const [fileName, setFileName] = useState("script.py");
  const editorRef = useRef(null);
  const file = files[fileName];

  function handleEditorDidMount(editor, monaco) {
    editorRef.current = editor;
  }

  function getEditorValue() {
    alert(editorRef.current.getValue());
  }

  return (
    <div className='App'>
      <button onClick={() => setFileName("index.html")}>
        Switch to index.html
      </button>
      <button onClick={() => setFileName("script.py")}>
        Switch to script.py
      </button>
      <button onClick={() => getEditorValue()}>
        Get editor value
      </button>
      <Editor
        height="100vh"
        width="100%"
        theme="vs-dark"
        onMount={handleEditorDidMount}
        path={file.name}
        defaultLanguage={file.language}
        defaultValue={file.value}
      />

    </div>
  )
}

export default App
