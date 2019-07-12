import axios from 'axios'

export default axios.create({
    baseURL: 'https://api.unsplash.com',
    headers: {
        Authorization: 'Client-ID c8648a21a066c161208d7926e82a9f2878028aef1b201d352d39f94789334efb'
    }
});

