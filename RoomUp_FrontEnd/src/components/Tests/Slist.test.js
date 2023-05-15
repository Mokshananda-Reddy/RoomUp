import React from 'react';
import { render, screen} from '@testing-library/react';
import { MemoryRouter} from "react-router-dom";
import Slist from "../../components/slist/Slist";
import '@testing-library/jest-dom/extend-expect';


test('renders add student button', () => {
    render(<MemoryRouter><Slist /></MemoryRouter>);
    const studenttext = screen.getByText('Add a new Student');
    expect(studenttext).toBeInTheDocument();
});