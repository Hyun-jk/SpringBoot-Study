import React from 'react';
import ListItem from "@mui/material/ListItem";
import ListItemText from "@mui/material/ListItemText";
import InputBase from "@mui/material//InputBase";
import Checkbox from "@mui/material/Checkbox";
import { IconButton, ListItemSecondaryAction } from '@mui/material';
import DeleteOutlinedIcon from '@mui/icons-material/DeleteOutlined';

class Todo extends React.Component{
    constructor(props){
        super(props);
        this.state = {item: props.item, readOnly : true};
        this.delte = props.delete;
    }

    deleteEventHandler = ()=>{
        this.delte(this.state.item)
    }

    offReadOnlyMode = () => {
        console.log("Event!", this.state.readOnly)
        this.setState({readOnly: false}, () => {
            console.log("ReadOnly?", this.state.readOnly)
        })
    }

    enterKeyEventHandler = (e) => {
        if (e.key === "Enter"){
            this.setState({readOnly : true});
        }
    }

    editEventHandler = (e) => {
        const thisItem = this.state.item;
        thisItem.title = e.target.value;
        this.setState({item: thisItem});

    }

    checkboxEventHandler = (e) => {
        const thisItem = this.state.item;
        thisItem.done = !thisItem.done;
        this.setState({ item : thisItem});
    }


    render(){
        const item = this.state.item;
    return(
        <ListItem>
            <Checkbox checked={item.done} onChange ={this.checkboxEventHandler} />
            <ListItemText>
                <InputBase
                    inputProps={{
                        "aria-label" : "naked",
                        readOnly : this.state.readOnly,
                    }} 
                    type="text"
                    id={item.id} //각 리스트를 구분하려고 id를 연결
                    name={item.id} //각 리스트를 구분하려고 id를 연결
                    value={item.title}
                    multiline={true}
                    fullWidth={true}
                    onClick = {this.offReadOnlyMode}
                    onChange = {this.editEventHandler}
                    onKeyPress ={this.enterKeyEventHandler}
                />
            </ListItemText>
        

            <ListItemSecondaryAction>
                <IconButton 
                    arai-label="Delete Todo"
                    onClick = {this.deleteEventHandler}>
                    <DeleteOutlinedIcon/>
                </IconButton>
            </ListItemSecondaryAction>
        </ListItem>
    );
    }
}

export default Todo;