import React, { Component } from 'react';

class DuplicateInputs extends Component {
  constructor(props) {
    super(props);
    this.state = {
      duplicates : "There are no duplicates"
    };
  }

  render() {
    return (
      <div><p>{this.state.duplicates}</p></div>
    );
  }
}

export default DuplicateInputs;
