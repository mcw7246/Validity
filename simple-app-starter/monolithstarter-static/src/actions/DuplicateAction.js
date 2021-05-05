import axios from 'axios';

export async function getDuplicateMessage() {
  return (await axios.get('/api/duplicates')).data;
}