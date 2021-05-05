import React, { Component } from 'react';
import { Container } from 'reactstrap';
import DuplicateInputs from '../components/Duplicates';

class DuplicatePage extends Component {
  render() {
    return (
      <div className='app'>
        <div className='app-body'>
          <Container fluid className='text-center'>
            <DuplicateInputs />
          </Container>
        </div>
      </div>
    );
  }
}

export default DuplicatePage;
