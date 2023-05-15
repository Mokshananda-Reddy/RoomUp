import React from 'react';
import { render, screen} from '@testing-library/react';
import { MemoryRouter} from "react-router-dom";
import Rlist from '../../components/rlist/Rlist';
import '@testing-library/jest-dom/extend-expect';


test('renders add request button', () => {
    render(<MemoryRouter><Rlist /></MemoryRouter>);
    const reqtext = screen.getByText('Add a new Request');
    expect(reqtext).toBeInTheDocument();
});